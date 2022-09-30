package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Admin;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.service.HygienistService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 卫生员
 */
@Controller
@RequestMapping("/hygienist")
public class HygienistController {

    @Autowired
    ResponseData responseData;
    @Autowired
    HygienistService hygienistService;

    //卫生员main首页
    @GetMapping("/main")
    public String main(){
        return "hygienist/main";
    }

    //去卫生员修改密码页面
    @GetMapping("/toUpdate_password")
    public String toUpdate_Password(){
        return "hygienist/update_password";
    }

    //去卫生员新增页面
    @GetMapping("/toHygienistAdd")
    public String toHygienistAdd(){
        return "admin/hygienist_add";
    }

    //去卫生员个人信息页面
    @GetMapping("/toHygienistInfo")
    public String toHygienistInfo(){
        return "hygienist/hygienist_info";
    }

    //去卫生员管理页面
    @GetMapping("/toHygienistManage")
    public String toHygienistManage(){
        return "admin/hygienist_manage";
    }

    //去卫生员修改页面
    @GetMapping("/toHygienistUpdate")
    public String toHygienistUpdate(){
        return "admin/hygienist_update";
    }

    //卫生员修改密码
    @ResponseBody
    @PostMapping("/update_password")
    public Map<String,Object> update_password(HttpServletRequest request, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取前端传的旧密码，新密码，确认密码
        String oldPwd = request.getParameter("oldPwd");
        String newPwd = request.getParameter("newPwd");
        String ConfirmPwd = request.getParameter("ConfirmPwd");
        //获取session里面登录的对象
        List<Hygienist> hygienistList = (List<Hygienist>)session.getAttribute("hygienist");
        Hygienist hygienist = hygienistList.get(0);
        if (!oldPwd.equals(hygienist.getHygienistPassword())){//旧密码和session里面对象的密码不一致
            map.put("status",responseData.STATUS_OLDPWD);
        }else if (!newPwd.equals(ConfirmPwd)){//新密码和确认密码不一致
            map.put("status",responseData.STATUS_ATYPISM);
        }else{
            hygienist.setHygienistPassword(newPwd);//新密码
            hygienistService.update(hygienist);//更新
            map.put("status",responseData.STATUS_SUCCESS);
        }
        return map;
    }
    
    //卫生员数据
    @GetMapping("/hygienistList")
    @ResponseBody
    public Map<String,Object> hygienistList(@RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Hygienist> hygienistList = hygienistService.queryAll(new Hygienist());
        int count = hygienistService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",hygienistList);
        return map;
    }

    //删除卫生员
    @DeleteMapping("/deleteHygienistById/{hygienistId}")
    @ResponseBody
    private Map<String, Object> deleteHygienistById(@PathVariable("hygienistId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        hygienistService.deleteById(id);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //卫生员修改
    @PostMapping("/updateHygienist")
    @ResponseBody
    private Map<String, Object> updateHygienist(@RequestBody Hygienist hygienist) {
        Map<String, Object> map = new HashMap<String, Object>();
        hygienistService.update(hygienist);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //卫生员新增
    @PostMapping("/addHygienist")
    @ResponseBody
    private Map<String, Object> addHygienist(@RequestBody Hygienist hygienist) {
        Map<String, Object> map = new HashMap<String, Object>();
        hygienist.setHygienistPassword("123456");
        hygienistService.insert(hygienist);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
