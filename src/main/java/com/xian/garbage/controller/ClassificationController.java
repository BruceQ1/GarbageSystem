package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Classification;
import com.xian.garbage.entity.Community;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.service.ClassificationService;
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
 * 垃圾分类
 */
@Controller
@RequestMapping("/classification")
public class ClassificationController {

    @Autowired
    ResponseData responseData;
    @Autowired
    ClassificationService classificationService;

    //去垃圾分类新增页面
    @GetMapping("/toClassificationAdd")
    public String toClassificationAdd(){
        return "admin/classification_add";
    }


    //去垃圾分类信息页面
    @GetMapping("/toClassificationInfo")
    public String toClassificationInfo(){
        return "hygienist/classification_info";
    }

    //去垃圾分类管理页面
    @GetMapping("/toClassificationManage")
    public String toClassificationManage(){
        return "admin/classification_manage";
    }

    //去垃圾分类修改页面
    @GetMapping("/toClassificationUpdate")
    public String toClassificationUpdate(){
        return "admin/classification_update";
    }

    //垃圾分类数据
    @GetMapping("/classificationList")
    @ResponseBody
    public Map<String,Object> classificationList(@RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Classification> classificationList = classificationService.queryAll(new Classification());
        int count = classificationService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",classificationList);
        return map;
    }

    //删除垃圾分类
    @DeleteMapping("/deleteClassificationById/{classificationId}")
    @ResponseBody
    private Map<String, Object> deleteClassificationById(@PathVariable("classificationId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        classificationService.deleteById(id);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //垃圾分类修改
    @PostMapping("/updateClassification")
    @ResponseBody
    private Map<String, Object> updateClassification(@RequestBody Classification classification) {
        Map<String, Object> map = new HashMap<String, Object>();
        classificationService.update(classification);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //垃圾分类新增
    @PostMapping("/addClassification")
    @ResponseBody
    private Map<String, Object> addClassification(@RequestBody Classification classification) {
        Map<String, Object> map = new HashMap<String, Object>();
        classificationService.insert(classification);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
