package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.vo.PropertyParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.PropertyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("property/")
public class PropertyController {
    @Resource
    private PropertyService propertyService;

    @GetMapping("queryPro")
    public ResultData queryPro(PropertyParams vo){
        if(vo.getCurrPage()==null){
            return ResultData.error(500,"参数错误");
        }
        if(vo.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=propertyService.queryPro(vo);
        return ResultData.success(map);
    }
}
