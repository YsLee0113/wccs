package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.code.entity.Noticeinfo;
import com.code.mapper.NoticeinfoMapper;
import com.code.util.GlobalResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台noticeinfo表的管理操作
 */
@Controller
@RequestMapping("/noticeinfo")
public class NoticeinfoController {

    @Autowired   //注入对象
    private NoticeinfoMapper noticeinfoMapper;

    @ResponseBody
    @RequestMapping("/apiinsert") //插入数据
    public GlobalResult apiinsert(Noticeinfo noticeinfo) {
        try {
            noticeinfoMapper.insert(noticeinfo);
            return GlobalResult.ok(noticeinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apiupdate") //修改数据
    public GlobalResult apiupdate(Noticeinfo noticeinfo) {
        try {
            noticeinfoMapper.updateById(noticeinfo);
            return GlobalResult.ok(noticeinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apidelete") //删除数据
    public GlobalResult apidelete(Integer id) {
        try {
            noticeinfoMapper.deleteById(id);
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
        EntityWrapper<Noticeinfo> queryWrapper = new EntityWrapper<Noticeinfo>();
        pageIndex = null == pageIndex ? 1 : pageIndex; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("noticeid", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("noticeid", false);  //根据id降序排列
        Page<Noticeinfo> sortPage = new Page<Noticeinfo>(pageIndex, pageSize);//参数一是当前页，参数二是每页个数
        List<Noticeinfo> noticeinfoList = noticeinfoMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总条数
        int current = sortPage.getCurrent();//当前页
        long pages = sortPage.getPages();//总页数
        Map resultMap = new HashMap();
        resultMap.put("list", noticeinfoList);
        resultMap.put("pageTotal", total);
        return GlobalResult.ok(resultMap);
    }


    @RequestMapping("/add")
    public String toAdd() {
        return "noticeinfo/noticeinfoAdd";
    }

    @RequestMapping("/insert") //插入数据
    public String save(Noticeinfo noticeinfo) {
        noticeinfoMapper.insert(noticeinfo);
        return "redirect:list";
    }

    @RequestMapping("/update") //修改数据
    public String update(Noticeinfo noticeinfo) {
        noticeinfoMapper.updateById(noticeinfo);
        return "redirect:list";
    }

    @RequestMapping("/delete") //删除数据
    public String save(int id) {
        noticeinfoMapper.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("/edit") //编辑数据
    public String edit(int id, Model model) {
        Noticeinfo noticeinfo = noticeinfoMapper.selectById(id);
        model.addAttribute("noticeinfo", noticeinfo);
        return "noticeinfo/noticeinfoUpdate";
    }

    @RequestMapping("/detail") //编辑数据
    public String detail(int id, Model model) {
        Noticeinfo noticeinfo = noticeinfoMapper.selectById(id);
        model.addAttribute("noticeinfo", noticeinfo);
        return "noticeinfo/noticeinfoDetail";
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

        p = null == p ? 1 : p; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        Page<Noticeinfo> sortPage = new Page<Noticeinfo>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Noticeinfo> noticeinfoList = noticeinfoMapper.selectPage(sortPage, null);
        long total = sortPage.getTotal(); //总页数
        int current = sortPage.getCurrent();
        long pages = sortPage.getPages();
        model.addAttribute("noticeinfoList", noticeinfoList);   //绑定接受参数
        model.addAttribute("cp", current);   //当前页
        model.addAttribute("tp", pages);   //总页数
        model.addAttribute("total", total);   //总条数
        model.addAttribute("pageListURL", "noticeinfo/list");   //总条数
        return "noticeinfo/noticeinfoList";
    }
}
