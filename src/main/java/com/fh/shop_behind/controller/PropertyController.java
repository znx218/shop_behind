package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.PropertyParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.PropertyService;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("property/")
@CrossOrigin
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

    @PostMapping("addPro")
    public ResultData addPro(Property property){
        propertyService.addPro(property);
        return ResultData.success("");
    }

    @DeleteMapping("delPro")
    public ResultData delPro(Integer id){
        propertyService.delPro(id);
        return ResultData.success("");
    }

    @PostMapping("updatePro")
    public ResultData updatePro(Property property){
        propertyService.updatePro(property);
        return ResultData.success("");
    }
}
