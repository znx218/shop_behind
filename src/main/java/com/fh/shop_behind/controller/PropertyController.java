package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.PropertyParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.PropertyService;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("property/")
@CrossOrigin
public class PropertyController {
    @Resource
    private PropertyService propertyService;

    //通过分类typeId查询所有属性 返回其属性值
    @GetMapping("queryProBytypeId")
    public ResultData queryProValueBytypeId(Integer typeId){
        List<Property> list=propertyService.queryProValueBytypeId(typeId);
        return ResultData.success(list);
    }

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

    /*根据类型id查询属性数据*/
    @GetMapping("selectShopProDataByTypeId")
    public ResultData selectShopProDataByTypeId(Integer typeId){
        Map map= propertyService.selectShopProDataByTypeId(typeId);
        return ResultData.success(map);
    }
}
