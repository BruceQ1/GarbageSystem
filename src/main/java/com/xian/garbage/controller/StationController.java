package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Classification;
import com.xian.garbage.entity.Station;
import com.xian.garbage.service.*;
import com.xian.garbage.service.StationService;
import com.xian.garbage.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 垃圾站
 */
@Controller
@RequestMapping("/station")
public class StationController {

    @Autowired
    ResponseData responseData;
    @Autowired
    StationService stationService;
    @Autowired
    ClassificationService classificationService;

    //去垃圾站新增页面
    @GetMapping("/toStationAdd")
    public String toStationAdd(Model model){
        List<Classification> classificationList = classificationService.queryAll(new Classification());
        model.addAttribute("classification",classificationList);
        return "admin/station_add";
    }

    //去垃圾站信息页面
    @GetMapping("/toStationInfo")
    public String toStationInfo(){
        return "hygienist/station_info";
    }

    //去垃圾站管理页面
    @GetMapping("/toStationManage")
    public String toStationManage(){
        return "admin/station_manage";
    }

    //去垃圾站修改页面
    @GetMapping("/toStationUpdate")
    public String toStationUpdate(Model model){
        List<Classification> classificationList = classificationService.queryAll(new Classification());
        model.addAttribute("classification",classificationList);
        return "admin/station_update";
    }

    //垃圾站数据
    @GetMapping("/stationList")
    @ResponseBody
    public Map<String,Object> stationList(@RequestParam(value = "page",defaultValue = "1")int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Station> stationList = stationService.queryAll(new Station());
        int count = stationService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",stationList);
        return map;
    }

    //删除垃圾站
    @DeleteMapping("/deleteStationById/{stationId}")
    @ResponseBody
    private Map<String, Object> deleteStationById(@PathVariable("stationId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        stationService.deleteById(id);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //垃圾站修改
    @PostMapping("/updateStation")
    @ResponseBody
    private Map<String, Object> updateStation(@RequestBody Station station) {
        Map<String, Object> map = new HashMap<String, Object>();
        stationService.update(station);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //垃圾站新增
    @PostMapping("/addStation")
    @ResponseBody
    private Map<String, Object> addStation(@RequestBody Station station) {
        Map<String, Object> map = new HashMap<String, Object>();
        stationService.insert(station);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
