package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Complain;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.entity.Repair;
import com.xian.garbage.service.ComplainService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 投诉记录
 */
@Controller
@RequestMapping("/complain")
public class ComplainController {

    @Autowired
    ResponseData responseData;
    @Autowired
    ComplainService complainService;

    //去投诉管理页面
    @GetMapping("/toComplainManage")
    public String toComplainManage(){
        return "admin/complain_manage";
    }

    //去投诉进度页面
    @GetMapping("/toComplainInfo")
    public String toComplainInfo(){
        return "hygienist/complain_info";
    }

    //去投诉界面
    @GetMapping("/toComplainAdd")
    public String toComplainAdd(){
        return "hygienist/complain_add";
    }

    //投诉
    @PostMapping("/addComplain")
    @ResponseBody
    private Map<String, Object> addComplain(@RequestBody Complain complain,HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        complain.setComplainStatus("投诉处理中");
        complain.setComplainTime(new Date());
        List<Hygienist> hygienistList = (List<Hygienist>) session.getAttribute("hygienist");
        complain.setHygienistName(hygienistList.get(0).getHygienistName());
        complainService.insert(complain);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //卫生员提交投诉记录数据
    @GetMapping("/complainByList")
    @ResponseBody
    public Map<String,Object> complainByList(@RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "limit", defaultValue = "10") int limit,
                                           HttpSession session){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Hygienist> hygienistList = (List<Hygienist>) session.getAttribute("hygienist");
        Complain complain = new Complain();
        complain.setHygienistName(hygienistList.get(0).getHygienistName());
        List<Complain> complainList = complainService.queryAll(complain);
        int count = complainList.size();
        map.put("count",count);
        map.put("code",0);
        map.put("data",complainList);
        return map;
    }

    //投诉记录数据
    @GetMapping("/complainList")
    @ResponseBody
    public Map<String,Object> complainList(@RequestParam(value = "page",defaultValue = "1")int page,
                                           @RequestParam(value = "limit", defaultValue = "10") int limit,
                                           HttpSession session){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Complain> complainList = complainService.queryAll(new Complain());
        int count = complainService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",complainList);
        return map;
    }

    //联系业主处理
    @PostMapping("/complainById/{complainId}")
    @ResponseBody
    private Map<String, Object> completeById(@PathVariable("complainId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Complain complain = new Complain();
        complain.setComplainId(id);
        complain.setComplainStatus("已联系业主处理");
        complainService.update(complain);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
