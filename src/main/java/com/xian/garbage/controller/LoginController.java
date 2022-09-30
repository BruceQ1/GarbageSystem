package com.xian.garbage.controller;

import com.xian.garbage.entity.Admin;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.service.AdminService;
import com.xian.garbage.service.HygienistService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录相关
 */
@Controller
public class LoginController {

    @Autowired
    ResponseData responseData;
    @Autowired
    AdminService adminService;
    @Autowired
    HygienistService hygienistService;

    //首页
    @GetMapping("/")
    public String index(){
        return "index";
    }

    //退出
    @GetMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "index";
    }

    //去管理员首页
    @GetMapping("/toAdmin")
    public String toAdmin(){
        return "admin/index";
    }

    //去卫生员首页
    @GetMapping("/toHygienist")
    public String toHygienist(){
        return "hygienist/index";
    }

    //登录方法
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request, HttpSession session){
        Map<String,Object> map = new HashMap<>();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        if (role.equals("admin")){
            Admin admin = new Admin(username,password);
            List<Admin> adminList = adminService.queryAll(admin);
            if (adminList.size()>0){
                session.setAttribute("admin",adminList);
                map.put("status",responseData.STATUS_ADMIN);
            }else {
                map.put("status",responseData.STATUS_FAIL);
            }
        }else if (role.equals("hygienist")){
            try {//处理账号为字符串的情况
                Hygienist hygienist = new Hygienist(Integer.parseInt(username), password);
                List<Hygienist> hygienistList = hygienistService.queryAll(hygienist);
                if (hygienistList.size() > 0) {
                    session.setAttribute("hygienist", hygienistList);
                    map.put("status", responseData.STATUS_TEACHER);
                } else {
                    map.put("status", responseData.STATUS_FAIL);
                }
            }catch (NumberFormatException numberFormatException){
                map.put("status", responseData.STATUS_FAIL);
            }
        }
        return map;
    }

}
