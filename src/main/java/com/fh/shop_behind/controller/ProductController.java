package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.po.ProductAttrData;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.ProductService;
import com.fh.shop_behind.utils.OssFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("product/")
@CrossOrigin
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("addProduct")
    public ResultData addProduct(Product product,String attr,String sku){
        productService.addProduct(product,attr,sku);
        return ResultData.success("");
    }




    @PostMapping("updatePro")
    public ResultData updatePro(Product product){
        productService.updatePro(product);
        return ResultData.success("");
    }

    @GetMapping("queryProduct")
    public ResultData queryProduct(PageParams params){
        Map map=productService.queryProduct(params);
        return ResultData.success(map);

    }

    @PostMapping("upload")
    public ResultData upload(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFile.uploadFile(file.getInputStream(),newName));
    }

    @PostMapping("delProduct")
    public ResultData delProduct(Product product){
        productService.delProduct(product);
        return ResultData.success("");
    }

    @GetMapping("queryDataByProId")
    public ResultData queryDataByProId(Integer proId){
        List<ProductAttrData> list=productService.queryDataByProId(proId);
        return ResultData.success(list);
    }
}
