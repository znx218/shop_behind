package com.fh.shop_behind.controller;


import com.fh.shop_behind.entity.po.Brand;
import com.fh.shop_behind.entity.vo.BrandParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.BrandService;
import com.fh.shop_behind.utils.FileInput;
import com.fh.shop_behind.utils.OssFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("brand/")
@CrossOrigin
public class BrandController {
    @Resource
    private BrandService brandService;

    @Resource
    private HttpServletRequest request;
    /*
     * 接口文档
     * 路径：http://localhost:8080/brand/queryBrandByPage
     * 请求方式：get
     * */

    @GetMapping("queryBrand")
    public ResultData queryBrand(){
        List<Brand> list=brandService.queryBrand();
        return ResultData.success(list);
    }

    @GetMapping("queryBrandByPage")
    public ResultData queryBrandByPage(BrandParams vo){
        if(vo.getCurrPage()==null){
            return ResultData.error(500,"参数错误");
        }
        if(vo.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=brandService.queryBrandByPage(vo);
        return ResultData.success(map);
    }

    /*
    * 3  接口文档
        路径：http://localhost:8080/brand/add
        请求方式：post请求
    * */
    @PostMapping("add")
    public ResultData add(Brand br){
        brandService.addBrand(br);
        return ResultData.success("");
    }


    /*
    * 3  接口文档
        路径：http://localhost:8080/brand/update
        请求方式：post请求
    * */
    @PostMapping("update")
    public ResultData updateBrand(Brand br) {
        brandService.updateBrand(br);
        return ResultData.success("");
    }

    /*
     * 路径：http://localhost:8080/brand/upload
     * 请求方式：post
     * */
    @PostMapping("upload")
    public ResultData upload(MultipartFile file) throws IOException {
        //处理新名称
            String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFile.uploadFile(file.getInputStream(),newName));
    }


}
