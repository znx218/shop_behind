package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Value;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.ValueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("value/")
public class ValueController {
    @Resource
    private ValueService valueService;

    @GetMapping("queryValue")
        public ResultData queryValue(Integer proId){
            if(proId==null){
                return ResultData.error(400,"参数错误");
            }
            List<Value> list=valueService.queryValue(proId);
            return ResultData.success(list);
        }

}
