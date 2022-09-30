package com.xian.garbage.controller;

import com.xian.garbage.entity.Admin;
import com.xian.garbage.service.AdminService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    ResponseData responseData;

    //管理员main首页
    @GetMapping("/main")
    public String main(){
        return "admin/main";
    }

    //去管理员修改密码页面
    @GetMapping("/toUpdate_password")
    public String toUpdate_Password(){
        return "admin/update_password";
    }

    //管理员修改密码
    @ResponseBody
    @PostMapping("/update_password")
    public Map<String,Object> update_password(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取前端传的旧密码，新密码，确认密码
        String oldPwd = request.getParameter("oldPwd");
        String newPwd = request.getParameter("newPwd");
        String ConfirmPwd = request.getParameter("ConfirmPwd");
        //获取session里面登录的对象
        List<Admin> adminList = (List<Admin>)session.getAttribute("admin");
        Admin admin = adminList.get(0);

        if (!oldPwd.equals(admin.getAdminPassword())){//旧密码和session里面对象的密码不一致
            map.put("status",responseData.STATUS_OLDPWD);
        }else if (!newPwd.equals(ConfirmPwd)){//新密码和确认密码不一致
            map.put("status",responseData.STATUS_ATYPISM);
        }else{
            admin.setAdminPassword(newPwd);//新密码
            adminService.update(admin);//更新
            map.put("status",responseData.STATUS_SUCCESS);
        }
        return map;
    }
}
