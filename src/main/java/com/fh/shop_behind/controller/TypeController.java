package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Type;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.TypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("api/type")
@CrossOrigin
public class TypeController {
    @Resource
    private TypeService typeService;

    /*
    * 接口文档
    * 路径：http://localhost:8080/api/type/getData
    * 请求方式：get
    * 返回值：{"code":200,"message":"success",data:[{ "id": 1,"name": "分类","pid": 0,"createDate": "2021-01-06","updateDate": "2021-01-20","isDel": 2}]}
    * */
    @GetMapping("getData")
    public ResultData getData(){
        List<Type> typelist=typeService.getData();
        return ResultData.success(typelist);
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/api/type/getData
     * 请求方式：get
     * 返回值：{"code":200,"message":"success",data:[{ "id": 2,"name": "电子产品","pid": 1,"createDate": "2021-01-04","updateDate": "2021-01-27","isDel": 2}]}
     * */
    @GetMapping("getDataByPid")
    public ResultData getDataByPid(Integer pid){
        List<Type> pidlist=typeService.getDataByPid(pid);
        return ResultData.success(pidlist);
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/api/type/add
     * 请求方式：post
     * 返回值：{"code":200,"message":"success",data:[{"id": 4}]}
     * */
    @PostMapping("add")
    public ResultData add(Type type){
       int id= typeService.add(type);
        return ResultData.success(id);

    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/api/type/queryTypeById
     * 请求方式：post
     * 返回值：{"code":200,"message":"success",data:[{  "id": 2,"name": "电子产品","pid": 1,"createDate": "2021-01-04","updateDate": "2021-01-27","isDel": 0}]}
     * */
    @PostMapping("queryTypeById")
    public ResultData queryByType(Integer id){
        Type type=typeService.queryByType(id);
        return  ResultData.success(type);
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/api/type/update
     * 请求方式：post
     * 返回值：{"code":200,"message":"success",data:[{"null"}]}
     * */
    @PostMapping("update")
    public ResultData update(Type type){
        typeService.update(type);
        return ResultData.success(null);
    }

}
