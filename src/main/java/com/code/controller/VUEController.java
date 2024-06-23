package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.code.entity.*;
import com.code.mapper.*;
import com.code.util.CommonUtils;
import com.code.util.GlobalResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;


@Controller
@CrossOrigin("*") //允许跨域请求
@RequestMapping("/vue")
public class VUEController {
    @Autowired   //注入对象
    private ExaminfoMapper examinfoMapper;
    @Autowired   //注入对象
    private ScoreinfoMapper scoreinfoMapper;
    @Autowired   //注入对象
    private CommonMapper commonMapper;

    @Autowired   //注入对象
    private NoticeinfoMapper noticeinfoMapper;
    @Autowired   //注入对象
    private UserinfoMapper userinfoMapper;
    @Autowired   //注入对象
    private SortinfoMapper sortinfoMapper;

    @Autowired   //注入对象
    private MsginfoMapper msginfoMapper;
    @Autowired   //注入对象
    private DatainfoMapper datainfoMapper;
    @Autowired   //注入对象
    private WorkinfoMapper workinfoMapper;

    @Autowired   //注入对象
    private HomeworkMapper homeworkMapper;
    @Autowired   //注入对象
    private StudyinfoMapper studyinfoMapper;

    //试卷提交
    @ResponseBody
    @RequestMapping("/examSubmit")
    public GlobalResult submitExaminfo(Model model, String username, String data) {
        System.out.println("data = " + data);
        String[] dataArr = data.split(",");
        int score = 0;
        String result = "";
        for (String s : dataArr) {
            String[] ss = s.split("===");
            Integer id = Integer.parseInt(ss[0]);
            String answer = ss[1];
            Examinfo examinfo = examinfoMapper.selectById(id);
            if (answer.equals(examinfo.getAnswer())) {
                score = score + Integer.parseInt(examinfo.getFenshu());
            }
            // ### 分隔多个题目
            result = result + s + "###";
        }

        // ### 去除多余的
        if (result.endsWith("###")) {
            result = result.substring(0, result.length() - 3);
        }
        System.out.println("result = " + result);
        System.out.println("score = " + score);
        Scoreinfo obj = new Scoreinfo();
        obj.setCreatetime(CommonUtils.getNowDateStr());
        obj.setResult(result);
        obj.setScore(score);
        obj.setUsername(username);
        scoreinfoMapper.insert(obj);
        return GlobalResult.ok();
    }


    //试卷页面
    @ResponseBody
    @RequestMapping("/examData")
    public GlobalResult exam(Integer sid, Model model, HttpSession session) {
        Sortinfo sortinfo = sortinfoMapper.selectById(sid);
        List<Examinfo> examinfoList = examinfoMapper.createExaminfo(sid);
        for (Examinfo examinfo : examinfoList) {
            List alist = new ArrayList();
            String xuanxiang = examinfo.getXuanxiang();
            String[] s = xuanxiang.split("##");
            //A.功能完善##B.界面美观##C.技术新颖##D.容易上手##E.简洁大方
            for (String s1 : s) {
                String[] s2 = s1.split("\\.");
                Map map = new HashMap();
                map.put("names", s2[1]);
                map.put("val", s2[0]);
                alist.add(map);
            }
            examinfo.setXuanxiangMap(alist);
            System.out.println("examinfo = " + examinfo);
        }

        return GlobalResult.ok(examinfoList);
    }

    //公共查询方法
    @ResponseBody
    @RequestMapping("/selectAction")
    public GlobalResult selectAction(String sql) {
        List<Map> mapList = commonMapper.selectAction(sql);
        return GlobalResult.ok(mapList);
    }

    //公共查询方法
    @ResponseBody
    @RequestMapping("/InsertHomework")
    public GlobalResult InsertHomework(Homework homework) {
        try {
            //异常代码
            homework.setSwtime(CommonUtils.getNowDateStr());
            homeworkMapper.insert(homework);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GlobalResult.ok();
    }

    //公共查询方法
    @ResponseBody
    @RequestMapping("/InsertDatainfo")
    public GlobalResult InsertDatainfo(Datainfo datainfo) {
        try {
            //异常代码
            datainfoMapper.insert(datainfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GlobalResult.ok();
    }

    //公共查询方法
    @ResponseBody
    @RequestMapping("/InsertWorkinfo")
    public GlobalResult InsertWorkinfo(Workinfo workinfo) {
        try {
            //异常代码
            workinfoMapper.insert(workinfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GlobalResult.ok();
    }

    //公共修改方法
    @ResponseBody
    @RequestMapping("/updateAction")
    public GlobalResult updateAction(String sql) {
        try {
            commonMapper.updateAction(sql);
            return GlobalResult.ok("操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return GlobalResult.ok("操作失败" + e.getMessage());
        }

    }


    //列表页面  分页搜索功能都有
    @ResponseBody
    @RequestMapping("/index")
    public GlobalResult index(String keyword, String adduser, String sorttype, Integer p) {
        System.out.println("vue进入系统首页......");
        p = null == p ? 1 : p; //默认显示第一页
        Integer pageSize = 6; //默认每页显示10条
        String para = ""; //除分页以外的其他参数
        EntityWrapper<Datainfo> queryWrapper = new EntityWrapper<Datainfo>();
        if (CommonUtils.isNotEmpty(keyword)) {
            queryWrapper.like("dataname", keyword);
            para = "&keyword=" + keyword;
            pageSize = 1000;
        }
        if (CommonUtils.isNotEmpty(adduser)) {
            queryWrapper.eq("datauser", adduser);
            para = "&adduser=" + keyword;
            pageSize = 1000;
        }
        if (CommonUtils.isNotEmpty(sorttype)) {
            queryWrapper.eq("datatype", sorttype);
            para = "&sorttype=" + sorttype;
        }
        queryWrapper.orderBy("dataid", true);  // order by id desc 根据id倒序
        Page<Datainfo> page = new Page<Datainfo>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Datainfo> datainfoList = datainfoMapper.selectPage(page, queryWrapper);
        long pages = page.getPages();//获取总分页数
        long total = page.getTotal();//获取数据总记录数
        int current = page.getCurrent();//获取当前页面
        Map map = new HashMap();
        map.put("records", datainfoList);
        map.put("current", current);
        map.put("pages", pages);
        map.put("total", total);
        return GlobalResult.ok(map);
    }


    @ResponseBody
    @RequestMapping("/checkName")
    public GlobalResult registerSubmit(String name, HttpSession session) {
        List<Userinfo> userinfoList = userinfoMapper.selectByMap(null);
        for (Userinfo u : userinfoList) {
            if (u.getName().equals(name)) {
                return GlobalResult.errorMsg("用户名已经存在");
            }
        }
        return GlobalResult.ok("可用使用");
    }


    //注册提交
    @ResponseBody
    @RequestMapping("/registerSubmit")
    public GlobalResult registerSubmit(Userinfo userinfo, HttpSession session) {
        List<Userinfo> userinfoList = userinfoMapper.selectByMap(null);
        for (Userinfo u : userinfoList) {
            if (u.getName().equals(userinfo.getName())) {
                return GlobalResult.errorMsg("用户名已经存在");
            }
            if (u.getPhone().equals(userinfo.getPhone())) {
                return GlobalResult.errorMsg("手机号已经存在");
            }
            if (u.getEmail().equals(userinfo.getEmail())) {
                return GlobalResult.errorMsg("邮箱已经存在");
            }
        }
        Integer insert = userinfoMapper.insert(userinfo);
        return GlobalResult.ok("用户注册成功");
    }


    //个人信息修改
    @ResponseBody
    @RequestMapping("/updateUserinfo")
    public GlobalResult updateUserinfo(HttpSession session, Userinfo userinfo) {
        Integer insert = userinfoMapper.updateById(userinfo);
        return GlobalResult.ok("个人信息修改成功");
    }

    //详情页面
    @ResponseBody
    @RequestMapping("/detail")
    public GlobalResult index(Integer id, Integer uid, HttpSession session) {
        Datainfo datainfo = datainfoMapper.selectById(id);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("tid", id);
        List<Msginfo> commentinfoList = msginfoMapper.selectByMap(map);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("datainfo", datainfo);
        resultMap.put("commentinfoList", commentinfoList);

        if (null != uid && !uid.equals(0)) {
            Userinfo userinfo = (Userinfo) session.getAttribute("loginUserinfo");
            Studyinfo studyinfo = new Studyinfo();
            studyinfo.setAddtime(CommonUtils.getNowDateStr());
            studyinfo.setTid(datainfo.getDataid() + "");
            studyinfo.setTname(datainfo.getDataname());
            studyinfo.setUsername(userinfo.getName());
            studyinfoMapper.insert(studyinfo);
        }

        return GlobalResult.ok(resultMap);
    }


    //验证码
    @ResponseBody
    @RequestMapping("/code")
    public GlobalResult code(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        int width = 60, height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
        g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        g.setColor(getRandColor(160, 200));
        for (int i = 0; i < 155; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.drawString(rand, 13 * i + 6, 16);
        }

        // 将认证码存入SESSION  sRand
        String contextPathHttp = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        g.dispose();
        String imgName = System.currentTimeMillis() + ".jpg";
        String savePath = request.getSession().getServletContext().getRealPath("/uploads/") + imgName;
        OutputStream out = new FileOutputStream(savePath); // 将图片生成到 e盘下面
        ImageIO.write(image, "JPEG", out);
        Map map = new HashMap();
        map.put("src", contextPathHttp + "uploads/" + imgName);
        map.put("code", sRand);
        return GlobalResult.ok(map);
    }

    //登陆提交验证
    @ResponseBody
    @RequestMapping("/loginSubmit") //插入数据
    public GlobalResult login(String username, String password, HttpSession session) {
        List<Userinfo> userinfoList = userinfoMapper.selectByMap(null);
        Userinfo userinfo = new Userinfo();
        boolean is = false;
        for (Userinfo user : userinfoList) {
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                userinfo = user;
                is = true;
                break;
            }
        }
        if (is) {
            return GlobalResult.ok(userinfo);
        } else {
            return GlobalResult.errorMsg("账号或者密码错误");
        }
    }


    //公共查询方法
    @ResponseBody
    @RequestMapping("/noticeinfoList")
    public GlobalResult noticeinfoList(String keyword) {
        EntityWrapper<Noticeinfo> queryWrapper = new EntityWrapper<Noticeinfo>();
        if (CommonUtils.isNotEmpty(keyword)) {
            queryWrapper.like("noticetitle", keyword);
        }
        List<Noticeinfo> noticeinfoList = noticeinfoMapper.selectList(queryWrapper);
        return GlobalResult.ok(noticeinfoList);
    }


    //发布信息保存
    @ResponseBody
    @RequestMapping("/sendSubmit")
    public GlobalResult sendSubmit(Datainfo datainfo, Model model, HttpSession session) {
        if (null != datainfo.getDataid() && datainfo.getDataid().equals(0)) {
            datainfoMapper.insert(datainfo);
        } else {
            datainfoMapper.updateById(datainfo);
        }

        return GlobalResult.ok(datainfo);
    }


    //图片验证码工具类
    Color getRandColor(int fc, int bc) {
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

}
