package com.code.controller;

import com.code.entity.Datainfo;
import com.code.entity.Scoreinfo;
import com.code.entity.Scoreinfo2;
import com.code.entity.Userinfo;
import com.code.mapper.*;
import com.code.util.GlobalResult;
import com.code.util.MyFilleUtil;
import com.code.utils.HadoopUtils;
import com.code.utils.HiveJDBCUtils;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据集： data.csv
 * 第一列：userid；第二列：itemid；第三列评分：score。
 * 教程
 * https://blog.csdn.net/huanhuanxiaoxiao/article/details/72828560
 */
@Controller
public class AlgorithmController {

    public static int ALGORITHM_TYPE = 1;//算法类型选择  1为基于物品的   2为基于用户的
    final static int NEIGHBORHOOD_NUM = 2;//临近的用户个数
    final static int RECOMMENDER_NUM = 10;//推荐物品的最大个数

    @Autowired   //注入对象
    public Scoreinfo2Mapper scoreinfo2Mapper;
    @Autowired   //注入对象
    public DatainfoMapper datainfoMapper;
    @Autowired   //注入对象
    public CommonMapper commonMapper;
    @Autowired   //注入对象
    public UserinfoMapper userinfoMapper;


    //添加评分  同时写入hdfs
    //  var url = '/algorithmSave';
    //  var data = {"uid": obj.uid,"tid": obj.tid,"score": obj.score};
    @ResponseBody
    @RequestMapping("/algorithmSave")
    public GlobalResult algorithmSave(HttpSession session, Scoreinfo2 scoreinfo, Model model) throws Exception {
        scoreinfo2Mapper.insert(scoreinfo);
        //List<Scoreinfo2> scoreinfoList = scoreinfo2Mapper.selectByMap(null);
        //HadoopUtils.writeScoreinfoHDFS(scoreinfoList);//
        return GlobalResult.ok("操作成功");
    }

    @ResponseBody
    @RequestMapping("/dataWrite")
    public GlobalResult dataWrite(HttpSession session, Model model) throws Exception {
        //写入数据
        List<Scoreinfo2> scoreinfoList = scoreinfo2Mapper.selectByMap(null);
        HadoopUtils.writeScoreinfoHDFS(scoreinfoList);//
        return GlobalResult.ok("操作成功");
    }


    //基于物品的
    @ResponseBody
    @RequestMapping("/algorithmData")
    public GlobalResult algorithmList(HttpSession session, HttpServletRequest request, String uid, Model model) throws Exception {
        String filePath = request.getSession().getServletContext().getRealPath("/uploads") + File.separatorChar + "data.csv";
        System.out.println("filePath = " + filePath);
        Userinfo user = userinfoMapper.selectById(uid);
        int myid = user.getId();
        //使用大数据操作
        List<Scoreinfo2> scoreinfoList = HadoopUtils.getHiveDataScoreinfo();
        //List<Scoreinfo2> scoreinfoList = scoreinfo2Mapper.selectByMap(null);

        String content = "";
        for (Scoreinfo2 scoreinfo : scoreinfoList) {
            content = content + scoreinfo.getUid() + "," + scoreinfo.getTid() + "," + scoreinfo.getScore() + "\n";
        }
        MyFilleUtil.WriteFile(filePath, content);

        //List<Integer> arr = userCF(filePath,myid);// 基于用户的
        List<Integer> arr = new ArrayList<Integer>();
        arr = itemCF(filePath, myid);// 基于物品的
        System.out.println("arr = " + arr);
        List<Datainfo> datainfoList = new ArrayList<Datainfo>();
        for (Integer tid : arr) {
            Datainfo datainfo = datainfoMapper.selectById(tid);
            if (null != datainfo) {
                datainfoList.add(datainfo);
            }
        }
        model.addAttribute("typeinfo", "基于物品的协同过滤算法");
        return GlobalResult.ok(datainfoList);
    }


    //基于用户的 CF（User CF） 推荐算法
    public static List<Integer> userCF(String filePath, int myid) throws Exception {
        List<Integer> arrList = new ArrayList<Integer>();
        DataModel model = new FileDataModel(new File(filePath));//数据模型
        UserSimilarity user = new EuclideanDistanceSimilarity(model);//用户相识度算法
        NearestNUserNeighborhood neighbor = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, user, model);
        //用户近邻算法
        Recommender r = new GenericUserBasedRecommender(model, neighbor, user);//用户推荐算法
        LongPrimitiveIterator iter = model.getUserIDs();///得到用户ID

        while (iter.hasNext()) {
            long uid = iter.nextLong();
            List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
                if (myid == uid) {
                    arrList.add((int) ritem.getItemID());
                }
            }
            System.out.println();

        }
        return arrList;
    }

    //基于物品的 CF 的基本原理 推荐算法
    public static List<Integer> itemCF(String filePath, int myid) throws Exception {
        List<Integer> arrList = new ArrayList<Integer>();
        DataModel model = new FileDataModel(new File(filePath));//数据模型
        ItemSimilarity item = new EuclideanDistanceSimilarity(model);//用户相识度算法
        Recommender r = new GenericItemBasedRecommender(model, item);//物品推荐算法
        LongPrimitiveIterator iter = model.getUserIDs();
        while (iter.hasNext()) {
            long uid = iter.nextLong();
            List<RecommendedItem> list = r.recommend(uid, RECOMMENDER_NUM);
            System.out.printf("uid:%s", uid);
            for (RecommendedItem ritem : list) {
                System.out.printf("(%s,%f)", ritem.getItemID(), ritem.getValue());
                if (myid == uid) {
                    arrList.add((int) ritem.getItemID());
                }
            }
            System.out.println();
        }
        return arrList;
    }


}
