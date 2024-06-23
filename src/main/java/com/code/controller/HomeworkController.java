/***
 **/
package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.code.entity.Homework;
import com.code.mapper.HomeworkMapper;
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
 * 后台homework表的管理操作
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {

    @Autowired   //注入对象
    private HomeworkMapper homeworkMapper;

    @ResponseBody
    @RequestMapping("/apiinsert") //插入数据
    public GlobalResult apiinsert(Homework homework) {
        try {
            homeworkMapper.insert(homework);
            return GlobalResult.ok(homework);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apiupdate") //修改数据
    public GlobalResult apiupdate(Homework homework) {
        try {
            homeworkMapper.updateById(homework);
            return GlobalResult.ok(homework);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apidelete") //删除数据
    public GlobalResult apidelete(Integer id) {
        try {
            homeworkMapper.deleteById(id);
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
        EntityWrapper<Homework> queryWrapper = new EntityWrapper<Homework>();
        pageIndex = null == pageIndex ? 1 : pageIndex; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("swid", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("swid", false);  //根据id降序排列
        Page<Homework> sortPage = new Page<Homework>(pageIndex, pageSize);//参数一是当前页，参数二是每页个数
        List<Homework> homeworkList = homeworkMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总条数
        int current = sortPage.getCurrent();//当前页
        long pages = sortPage.getPages();//总页数
        Map resultMap = new HashMap();
        resultMap.put("list", homeworkList);
        resultMap.put("pageTotal", total);
        return GlobalResult.ok(resultMap);
    }

    @RequestMapping("/add")
    public String toAdd() {
        return "homework/homeworkAdd";
    }

    @RequestMapping("/insert") //插入数据
    public String save(Homework homework) {
        homeworkMapper.insert(homework);
        return "redirect:list";
    }

    @RequestMapping("/update") //修改数据
    public String update(Homework homework) {
        homeworkMapper.updateById(homework);
        return "redirect:list";
    }

    @RequestMapping("/delete") //删除数据
    public String save(int id) {
        homeworkMapper.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("/edit") //编辑数据
    public String edit(int id, Model model) {
        Homework homework = homeworkMapper.selectById(id);
        model.addAttribute("homework", homework);
        return "homework/homeworkUpdate";
    }

    @RequestMapping("/detail") //编辑数据
    public String detail(int id, Model model) {
        Homework homework = homeworkMapper.selectById(id);
        model.addAttribute("homework", homework);
        return "homework/homeworkDetail";
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
        Page<Homework> sortPage = new Page<Homework>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Homework> homeworkList = homeworkMapper.selectPage(sortPage, null);
        long total = sortPage.getTotal(); //总页数
        int current = sortPage.getCurrent();
        long pages = sortPage.getPages();
        model.addAttribute("homeworkList", homeworkList);   //绑定接受参数
        model.addAttribute("cp", current);   //当前页
        model.addAttribute("tp", pages);   //总页数
        model.addAttribute("total", total);   //总条数
        model.addAttribute("pageListURL", "homework/list");   //总条数
        return "homework/homeworkList";
    }
}
