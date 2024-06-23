package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.code.entity.*;
import com.code.mapper.*;
import com.code.util.CommonUtils;
import com.code.util.GlobalResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@CrossOrigin("*") //允许跨域请求
public class IndexController {
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

    //公共查询方法
    @ResponseBody
    @RequestMapping("/selectAction")
    public GlobalResult selectAction(String sql) {
        List<Map> mapList = commonMapper.selectAction(sql);
        return GlobalResult.ok(mapList);
    }

    //公共修改方法
    @ResponseBody
    @RequestMapping("/updateAction")
    public GlobalResult updateAction(String sql) {
        commonMapper.updateAction(sql);
        return GlobalResult.ok("操作成功");
    }

    //公共分页查询方法
    @ResponseBody
    @RequestMapping("/selectPageAction")
    public GlobalResult selectPageAction(String sql, String p, Integer pageSize) {
        int pageNum = 1;

        if (null != p) {
            pageNum = Integer.parseInt(p);
        }
        if (null == pageSize) {
            pageSize = 10;
        }
        Integer total = 0;
        List<Map> mapList = commonMapper.selectAction(sql);
        total = mapList.size();
        long pages = total / pageSize;
        if (total % pageSize > 0) {
            pages = pages + 1;
        }
        String sqlTwo = sql + " limit " + (pageNum - 1) * pageSize + "," + pageSize + " ";
        List<Map> records = commonMapper.selectAction(sqlTwo);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pages", pages);
        map.put("current", pageNum);
        map.put("records", records);
        map.put("total", total);
        return GlobalResult.ok(map);
    }


}
