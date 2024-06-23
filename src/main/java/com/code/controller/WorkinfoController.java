/***
 **/
package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.code.entity.Workinfo;
import com.code.mapper.WorkinfoMapper;
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
 * 后台workinfo表的管理操作
 */
@Controller
@RequestMapping("/workinfo")
public class WorkinfoController {

    @Autowired   //注入对象
    private WorkinfoMapper workinfoMapper;

    @ResponseBody
    @RequestMapping("/apiinsert") //插入数据
    public GlobalResult apiinsert(Workinfo workinfo) {
        try {
            workinfoMapper.insert(workinfo);
            return GlobalResult.ok(workinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apiupdate") //修改数据
    public GlobalResult apiupdate(Workinfo workinfo) {
        try {
            workinfoMapper.updateById(workinfo);
            return GlobalResult.ok(workinfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apidelete") //删除数据
    public GlobalResult apidelete(Integer id) {
        try {
            workinfoMapper.deleteById(id);
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
        EntityWrapper<Workinfo> queryWrapper = new EntityWrapper<Workinfo>();
        pageIndex = null == pageIndex ? 1 : pageIndex; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("wid", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("wid", false);  //根据id降序排列
        Page<Workinfo> sortPage = new Page<Workinfo>(pageIndex, pageSize);//参数一是当前页，参数二是每页个数
        List<Workinfo> workinfoList = workinfoMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总条数
        int current = sortPage.getCurrent();//当前页
        long pages = sortPage.getPages();//总页数
        Map resultMap = new HashMap();
        resultMap.put("list", workinfoList);
        resultMap.put("pageTotal", total);
        return GlobalResult.ok(resultMap);
    }


    @RequestMapping("/add")
    public String toAdd() {
        return "workinfo/workinfoAdd";
    }

    @RequestMapping("/insert") //插入数据
    public String save(Workinfo workinfo) {
        workinfoMapper.insert(workinfo);
        return "redirect:list";
    }

    @RequestMapping("/update") //修改数据
    public String update(Workinfo workinfo) {
        workinfoMapper.updateById(workinfo);
        return "redirect:list";
    }

    @RequestMapping("/delete") //删除数据
    public String save(int id) {
        workinfoMapper.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("/edit") //编辑数据
    public String edit(int id, Model model) {
        Workinfo workinfo = workinfoMapper.selectById(id);
        model.addAttribute("workinfo", workinfo);
        return "workinfo/workinfoUpdate";
    }

    @RequestMapping("/detail") //编辑数据
    public String detail(int id, Model model) {
        Workinfo workinfo = workinfoMapper.selectById(id);
        model.addAttribute("workinfo", workinfo);
        return "workinfo/workinfoDetail";
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
        Page<Workinfo> sortPage = new Page<Workinfo>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Workinfo> workinfoList = workinfoMapper.selectPage(sortPage, null);
        long total = sortPage.getTotal(); //总页数
        int current = sortPage.getCurrent();
        long pages = sortPage.getPages();
        model.addAttribute("workinfoList", workinfoList);   //绑定接受参数
        model.addAttribute("cp", current);   //当前页
        model.addAttribute("tp", pages);   //总页数
        model.addAttribute("total", total);   //总条数
        model.addAttribute("pageListURL", "workinfo/list");   //总条数
        return "workinfo/workinfoList";
    }
}
