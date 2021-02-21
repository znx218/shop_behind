package com.fh.shop_behind.controller;


import com.fh.shop_behind.entity.po.Edui;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.EduiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("edui/")
@CrossOrigin
public class EduiController {

    @Resource
    private EduiService eduiService;


    /*
     * 接口文档
     * 路径：http://localhost:8080/edui/selectEdui
     * 请求方式：get
     * */
   @GetMapping("selectEdui")
    public ResultData selectEdui(){
        List<Edui> list =eduiService.selectEdui();
        return ResultData.success(list);
    }
}
