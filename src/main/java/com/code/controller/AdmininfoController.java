package com.code.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.code.entity.Admininfo;
import com.code.mapper.AdmininfoMapper;
import com.code.mapper.CommonMapper;
import com.code.mapper.NoticeinfoMapper;
import com.code.util.CommonUtils;
import com.code.util.GlobalResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admininfo")
public class AdmininfoController {
    @Autowired   //注入对象
    private AdmininfoMapper admininfoMapper;
    @Autowired   //注入对象
    private CommonMapper commonMapper;
    @Autowired   //注入对象
    private NoticeinfoMapper noticeinfoMapper;

    //管理员登陆提交验证
    @ResponseBody
    @RequestMapping("/apiSystemData") //插入数据
    public GlobalResult apiSystemData() {
        Map resultMap = new HashMap();
        //统计数据库中的数据
        resultMap.put("userinfo", commonMapper.selectAction("select count(*) as nums from userinfo ").get(0).get("nums"));
        resultMap.put("datainfo", commonMapper.selectAction("select count(*) as nums from datainfo ").get(0).get("nums"));
        resultMap.put("noticeinfo", commonMapper.selectAction("select count(*) as nums from noticeinfo ").get(0).get("nums"));
        resultMap.put("noticeData", noticeinfoMapper.selectByMap(null));
        return GlobalResult.ok(resultMap);
    }

    //管理员登陆提交验证
    @ResponseBody
    @RequestMapping("/apilogin") //插入数据
    public GlobalResult apilogin(String username, String password, HttpSession session, Model model) {
        List<Admininfo> admininfoList = admininfoMapper.selectByMap(null);
        Admininfo admin = new Admininfo();
        boolean is = false;
        for (Admininfo admininfo : admininfoList) {
            if (admininfo.getAdminname().equals(username) && admininfo.getAdminpwd().equals(password)) {
                admin = admininfo;
                is = true;
                break;
            }
        }
        if (is) {
            //登录成功
            return GlobalResult.ok(admin);
        } else {
            return GlobalResult.errorMsg("账号或者密码错误");
        }
    }

    @ResponseBody
    @RequestMapping("/apiinsert") //插入数据
    public GlobalResult apiinsert(Admininfo admininfo) {
        try {
            admininfoMapper.insert(admininfo);
            return GlobalResult.ok(admininfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apiupdate") //修改数据
    public GlobalResult apiupdate(Admininfo admininfo) {
        try {
            admininfoMapper.updateById(admininfo);
            return GlobalResult.ok(admininfo);
        } catch (Exception e) {
            return GlobalResult.errorMsg(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/apidelete") //删除数据
    public GlobalResult apidelete(Integer id) {
        try {
            admininfoMapper.deleteById(id);
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
        EntityWrapper<Admininfo> queryWrapper = new EntityWrapper<Admininfo>();
        pageIndex = null == pageIndex ? 1 : pageIndex; //默认显示第一页
        pageSize = null == pageSize ? 10 : pageSize; //默认每页显示10条
        if (StringUtils.isNotEmpty(keyword)) {
            queryWrapper.like("adminid", keyword); //根据字段搜索查询
        }
        queryWrapper.orderBy("adminid", false);  //根据id降序排列
        Page<Admininfo> sortPage = new Page<Admininfo>(pageIndex, pageSize);//参数一是当前页，参数二是每页个数
        List<Admininfo> admininfoList = admininfoMapper.selectPage(sortPage, queryWrapper);
        long total = sortPage.getTotal(); //总条数
        int current = sortPage.getCurrent();//当前页
        long pages = sortPage.getPages();//总页数
        Map resultMap = new HashMap();
        resultMap.put("list", admininfoList);
        resultMap.put("pageTotal", total);
        return GlobalResult.ok(resultMap);
    }


    @RequestMapping("/login") //插入数据
    public String login(String username, String password, String type, HttpSession session, Model model) {

        List<Admininfo> admininfoList = admininfoMapper.selectByMap(null);
        Admininfo admin = new Admininfo();
        boolean is = false;
        for (Admininfo admininfo : admininfoList) {
            if (admininfo.getAdminname().equals(username) && admininfo.getAdminpwd().equals(password)) {
                admin = admininfo;
                is = true;
                break;
            }
        }
        if (is) {
            if (!admin.getIslock().equals("可用")) {
                model.addAttribute("msg", "用户已经被禁用");
                return "admin/login";
            }
            session.setAttribute("loginUser", admin);
            session.setAttribute("loginType", "管理员");
            return "redirect:tomain";
        } else {
            model.addAttribute("msg", "账号或者密码错误");
            return "admin/login";
        }
    }


    @RequestMapping("/tologin")
    public String tologin(HttpSession session) {
        return "admin/login";
    }

    @RequestMapping("/tomain")
    public String tomain(HttpSession session) {
        return "admin/main";
    }


    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session) {
        session.invalidate();
        return "admin/login";
    }

    @RequestMapping("/register")
    public String register(Admininfo admininfo, Model model) {
        admininfo.setAdmincreatetime(CommonUtils.getNowDateStr());
        admininfoMapper.insert(admininfo);
        model.addAttribute("msg", "用户注册成功，请登录");
        return "admin/login";
    }

    @RequestMapping("/add")
    public String toAdd() {
        return "admininfo/admininfoAdd";
    }

    @RequestMapping("/insert") //插入数据
    public String save(Admininfo admininfo) {
        admininfoMapper.insert(admininfo);
        return "redirect:list";
    }


    @RequestMapping("/update") //修改数据
    public String update(Admininfo admininfo) {
        admininfoMapper.updateById(admininfo);
        return "redirect:list";
    }

    @RequestMapping("/delete") //删除数据
    public String save(int id) {
        admininfoMapper.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("/edit") //编辑数据
    public String edit(int id, Model model) {
        Admininfo admininfo = admininfoMapper.selectById(id);
        model.addAttribute("admininfo", admininfo);
        return "admininfo/admininfoUpdate";
    }

    @RequestMapping("/detail") //编辑数据
    public String detail(int id, Model model) {
        Admininfo admininfo = admininfoMapper.selectById(id);
        model.addAttribute("admininfo", admininfo);
        return "admininfo/admininfoDetail";
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
        Page<Admininfo> sortPage = new Page<Admininfo>(p, pageSize);//参数一是当前页，参数二是每页个数
        List<Admininfo> admininfoList = admininfoMapper.selectPage(sortPage, null);
        long total = sortPage.getTotal(); //总页数
        int current = sortPage.getCurrent();
        long pages = sortPage.getPages();
        model.addAttribute("admininfoList", admininfoList);   //绑定接受参数
        model.addAttribute("cp", current);   //当前页
        model.addAttribute("tp", pages);   //总页数
        model.addAttribute("total", total);   //总条数
        model.addAttribute("pageListURL", "admininfo/list");   //总条数
        return "admininfo/admininfoList";
    }

}
