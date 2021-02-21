package com.fh.shop_behind.controller;


import com.fh.shop_behind.entity.po.Dept;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("dept/")
@CrossOrigin
public class DeptController {
    @Resource
    private DeptService deptService;

    /*
     * 接口文档
     * 路径：http://localhost:8080/dept/selectDept
     * 请求方式：get
     * */
   @GetMapping("selectDept")
    public ResultData selectDept(){
        List<Dept> rs =deptService.selectDept();
        return ResultData.success(rs);
    }

    /*@RequestMapping("addDept")
    @ResponseBody
    public Map addDept(String name){
        Map map=deptService.addDept(name);
        return map;
    }

    @RequestMapping("updateDept")
    @ResponseBody
    public Map updateDept(User user){
        Map map=deptService.updateDept(user);
        return map;

    }*/

}
