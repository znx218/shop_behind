package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Value;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.ValueService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("value/")
@CrossOrigin
public class ValueController {
    @Resource
    private ValueService valueService;

    @GetMapping("queryValueByproId")
    public ResultData queryValueByproId(Integer proId){
        List<Value> list=valueService.queryValueByproId(proId);
        return ResultData.success(list);
    }

    @GetMapping("queryValue")
        public ResultData queryValue(Integer proId){
            if(proId==null){
                return ResultData.error(400,"参数错误");
            }
            List<Value> list=valueService.queryValue(proId);
            return ResultData.success(list);
        }

        @PostMapping("addValue")
        public ResultData addValue(Value va){
            valueService.addValue(va);
            return  ResultData.success(null);
        }

        @PostMapping("updateValue")
        public ResultData updateValue(Value va){
            valueService.updateValue(va);
            return ResultData.success("");
        }

        @DeleteMapping("delValue")
         public ResultData delValue(Integer id){
            valueService.delValue(id);
            return ResultData.success("");
        }



}
