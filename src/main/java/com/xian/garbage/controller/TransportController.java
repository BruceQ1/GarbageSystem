package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xian.garbage.entity.*;
import com.xian.garbage.service.ClassificationService;
import com.xian.garbage.service.CommunityService;
import com.xian.garbage.service.StationService;
import com.xian.garbage.service.TransportService;
import com.xian.garbage.util.ResponseData;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运输信息
 */
@Controller
@RequestMapping("/transport")
public class TransportController {

    @Autowired
    ResponseData responseData;
    @Autowired
    TransportService transportService;
    @Autowired
    CommunityService communityService;
    @Autowired
    StationService stationService;
    @Autowired
    ClassificationService classificationService;

    //去运输管理页面
    @GetMapping("/toTransportManage")
    public String toTransportManage(){
        return "admin/transport_manage";
    }

    //去运输信息页面
    @GetMapping("/toTransportInfo")
    public String toTransportInfo(){
        return "hygienist/transport_info";
    }

    //运输记录新增
    @PostMapping("/addTransport")
    @ResponseBody
    private Map<String, Object> addTransport(@RequestBody Transport transport) {
        Map<String, Object> map = new HashMap<String, Object>();
        transport.setTransportTime(new Date());
        transport.setTransportStatus("运输中");
        transportService.insert(transport);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //去运输管理页面
    @GetMapping("/toTransportAdd")
    public String toTransportAdd(Model model){
        List<Station> stationList = stationService.queryAll(new Station());
        List<Community> communityList = communityService.queryAll(new Community());
        List<Classification> classificationList = classificationService.queryAll(new Classification());
        model.addAttribute("classification",classificationList);
        model.addAttribute("station",stationList);
        model.addAttribute("community",communityList);
        return "hygienist/transport_add";
    }

    //运输记录数据
    @GetMapping("/transportList")
    @ResponseBody
    public Map<String,Object> transportList(@RequestParam(value = "page",defaultValue = "1")int page,
                                            @RequestParam(value = "limit", defaultValue = "10") int limit){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Transport> transportList = transportService.queryAll(new Transport());
        int count = transportService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",transportList);
        return map;
    }

    //运输完成
    @PostMapping("/completeById/{transportId}")
    @ResponseBody
    private Map<String, Object> completeById(@PathVariable("transportId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Transport transport = new Transport();
        transport.setTransportId(id);
        transport.setTransportStatus("已完成");
        transportService.update(transport);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
