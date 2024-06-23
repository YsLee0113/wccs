package com.code.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.code.mapper.ScoreinfoMapper;
import com.code.entity.Scoreinfo;
import com.code.util.CommonUtils;
import com.code.util.GlobalResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台scoreinfo表的结果管理操作
 */
@Controller
@CrossOrigin("*") //支持跨域请求
@RequestMapping("/scoreinfo")
public class ScoreinfoController {

    @Autowired   //注入对象
    public ScoreinfoMapper scoreinfoMapper;

    @ResponseBody
    @RequestMapping("/apiinsert") //插入数据
    public GlobalResult apiinsert(Scoreinfo scoreinfo) {
        try {
            scoreinfoMapper.insert(scoreinfo);
            return GlobalResult.ok(scoreinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apiupdate") //修改数据
    public GlobalResult apiupdate(Scoreinfo scoreinfo) {
        try {
            scoreinfoMapper.updateById(scoreinfo);
            return GlobalResult.ok(scoreinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apidelete") //删除数据
    public GlobalResult apidelete(Integer id) {
        try {
            scoreinfoMapper.deleteById(id);
            return GlobalResult.ok("删除成功");
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }


    /**
     * 接口分页查询
     *
     * @param keyword   搜索关键词
     * @param pageIndex 页码
     * @param pageSize  每页查询条数
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/apilist") //分页查询数据
    public Object apilist(String keyword, Integer pageIndex, Integer pageSize, Model model) {
        EntityWrapper<Scoreinfo> queryWrapper = new EntityWrapper<Scoreinfo>();
        pageIndex = null == pageIndex ? 1 : pageIndex; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("username", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("id", false);  //根据id降序排列
        Page<Scoreinfo> sortPage = new Page<Scoreinfo>(pageIndex, pageSize);//参数一是当前页，参数二是每页个数
        List<Scoreinfo> scoreinfoList = scoreinfoMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总条数
        int current = sortPage.getCurrent();//当前页
        long pages = sortPage.getPages();//总页数
        Map resultMap = new HashMap();
        resultMap.put("list", scoreinfoList);
        resultMap.put("pageTotal", total);
        return GlobalResult.ok(resultMap);
    }


    @RequestMapping("/add")  //跳转添加页面
    public String toAdd(Model model) {
        return "scoreinfo/scoreinfoAdd";
    }

    @RequestMapping("/insert") //插入数据
    public String save(Scoreinfo scoreinfo) {
        scoreinfoMapper.insert(scoreinfo);
        return "redirect:list";
    }

    @RequestMapping("/update") //修改数据
    public String update(Scoreinfo scoreinfo) {
        scoreinfoMapper.updateById(scoreinfo);
        return "redirect:list";
    }

    @RequestMapping("/delete") //删除数据
    public String delete(Integer id) {
        scoreinfoMapper.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("/edit") //编辑数据
    public String edit(String id, Model model) {
        Scoreinfo scoreinfo = scoreinfoMapper.selectById(id);
        model.addAttribute("scoreinfo", scoreinfo);
        return "scoreinfo/scoreinfoUpdate";
    }

    @RequestMapping("/detail") //详情查看
    public String detail(String id, Model model) {
        Scoreinfo scoreinfo = scoreinfoMapper.selectById(id);
        model.addAttribute("scoreinfo", scoreinfo);
        return "scoreinfo/scoreinfoDetail";
    }

    /**
     * @param keyword  搜索关键词
     * @param p        页面            默认第1页
     * @param pageSize 每页显示条数 默认每页10条
     * @param model
     * @return
     */
    @RequestMapping("/list") //分页查询数据
    public String list(String keyword, Integer p, Integer pageSize, Model model) {
        EntityWrapper<Scoreinfo> queryWrapper = new EntityWrapper<Scoreinfo>();
        p = null == p ? 1 : p; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("username", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("id", false);  //根据id降序排列
        Page<Scoreinfo> sortPage = new Page<Scoreinfo>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Scoreinfo> scoreinfoList = scoreinfoMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总页数
        int current = sortPage.getCurrent();
        long pages = sortPage.getPages();
        model.addAttribute("scoreinfoList", scoreinfoList);   //绑定接受参数
        model.addAttribute("cp", current);   //当前页
        model.addAttribute("tp", pages);   //总页数
        model.addAttribute("total", total);   //总条数
        model.addAttribute("pageListURL", "scoreinfo/list");   //总条数
        return "scoreinfo/scoreinfoList";
    }
}
