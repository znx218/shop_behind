package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("product/")
public class ProductController {
    @Resource
    private ProductService productService;

    @PostMapping("addProduct")
    public ResultData addProduct(Product product){
        productService.addProduct(product);
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
}
