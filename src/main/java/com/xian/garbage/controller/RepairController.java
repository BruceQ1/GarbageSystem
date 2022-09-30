package com.xian.garbage.controller;

import com.github.pagehelper.PageHelper;
import com.xian.garbage.entity.Hygienist;
import com.xian.garbage.entity.Repair;
import com.xian.garbage.entity.Transport;
import com.xian.garbage.service.RepairService;
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
 * 维修记录
 */
@Controller
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    ResponseData responseData;
    @Autowired
    RepairService repairService;

    //去维修管理页面
    @GetMapping("/toRepairManage")
    public String toRepairManage(){
        return "admin/repair_manage";
    }

    //去报修申请页面
    @GetMapping("/toRepairAdd")
    public String toRepairAdd(){
        return "hygienist/repair_add";
    }

    //去报修进度页面
    @GetMapping("/toRepairInfo")
    public String toRepairInfo(){
        return "hygienist/repair_info";
    }

    //报修记录申请
    @PostMapping("/addRepair")
    @ResponseBody
    private Map<String, Object> addRepair(@RequestBody Repair repair,HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        repair.setRepairStatus("报修中");
        repair.setRepairTime(new Date());
        List<Hygienist> hygienistList = (List<Hygienist>) session.getAttribute("hygienist");
        repair.setHygienistName(hygienistList.get(0).getHygienistName());
        repairService.insert(repair);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }

    //卫生员查看自己提交的报修记录数据
    @GetMapping("/repairByList")
    @ResponseBody
    public Map<String,Object> repairByList(@RequestParam(value = "page",defaultValue = "1")int page,
                                         @RequestParam(value = "limit", defaultValue = "10") int limit,
                                         HttpSession session){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Hygienist> hygienistList = (List<Hygienist>) session.getAttribute("hygienist");
        Repair repair = new Repair();
        repair.setHygienistName(hygienistList.get(0).getHygienistName());
        List<Repair> repairList =  repairService.queryAll(repair);
        int count = repairList.size();
        map.put("count",count);
        map.put("code",0);
        map.put("data",repairList);
        return map;
    }

    //报修记录数据
    @GetMapping("/repairList")
    @ResponseBody
    public Map<String,Object> repairList(@RequestParam(value = "page",defaultValue = "1")int page,
                                         @RequestParam(value = "limit", defaultValue = "10") int limit,
                                         HttpSession session){
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Repair> repairList = repairService.queryAll(new Repair());
        int count = repairService.count();
        map.put("count",count);
        map.put("code",0);
        map.put("data",repairList);
        return map;
    }

    //维修完成
    @PostMapping("/repairById/{repairId}")
    @ResponseBody
    private Map<String, Object> completeById(@PathVariable("repairId") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Repair repair = new Repair();
        repair.setRepairId(id);
        repair.setRepairStatus("已维修");
        repairService.update(repair);
        map.put("status", responseData.STATUS_SUCCESS);
        return map;
    }
}
