package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Community;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.service.CommunityService;
import com.xian.garbage.service.HygienistService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小区
 */
@Controller
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    ResponseData responseData;
    @Autowired
    HygienistService hygienistService;
    @Autowired
    CommunityService communityService;

    //去小区新增页面
    @GetMapping("/toCommunityAdd")
    public String toCommunityAdd(Model model){
        List<Hygienist> hygienistList = hygienistService.queryAll(new Hygienist());
        model.addAttribute("hygienist",hygienistList);
        return "admin/community_add";
    }

    //去小区信息页面
    @GetMapping("/toCommunityInfo")
    public String toCommunityInfo(){
        return "hygienist/community_info";
    }

    //去小区管理页面
    @GetMapping("/toCommunityManage")
    public String toCommunityManage(){
        return "admin/community_manage";
    }

    //去小区修改页面
    @GetMapping("/toCommunityUpdate")
    public String toCommunityUpdate(Model model){
        List<Hygienist> hygienistList = hygienistService.queryAll(new Hygienist());
        model.addAttribute("hygienist",hygienistList);
        return "admin/community_update";
    }

    //小区数据
    @GetMapping("/communityList")
    @ResponseBody
    public Map<String,Object> communityList(@RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Community> communityList = communityService.queryAll(new Community());
        int count = communityService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",communityList);
        return map;
    }

    //删除小区
    @DeleteMapping("/deleteCommunityById/{communityId}")
    @ResponseBody
    private Map<String, Object> deleteCommunityById(@PathVariable("communityId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        communityService.deleteById(id);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //小区修改
    @PostMapping("/updateCommunity")
    @ResponseBody
    private Map<String, Object> updateCommunity(@RequestBody Community community) {
        Map<String, Object> map = new HashMap<String, Object>();
        Hygienist hygienist = new Hygienist();
        hygienist.setHygienistName(community.getHygienistName());
        List<Hygienist> hygienistList = hygienistService.queryAll(hygienist);
        community.setHygienistPhone(hygienistList.get(0).getHygienistPhone());
        community.setHygienistMail(hygienistList.get(0).getHygienistMail());
        community.setCommunityCreate(new Date());
        communityService.update(community);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //小区新增
    @PostMapping("/addCommunity")
    @ResponseBody
    private Map<String, Object> addCommunity(@RequestBody Community community) {
        Map<String, Object> map = new HashMap<String, Object>();
        Hygienist hygienist = new Hygienist();
        hygienist.setHygienistName(community.getHygienistName());
        List<Hygienist> hygienistList = hygienistService.queryAll(hygienist);
        community.setHygienistPhone(hygienistList.get(0).getHygienistPhone());
        community.setHygienistMail(hygienistList.get(0).getHygienistMail());
        community.setCommunityCreate(new Date());
        communityService.insert(community);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
