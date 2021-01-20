package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.ProductDao;
import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public void addProduct(Product product) {
        product.setAuthor("znx");
        product.setCreateDate(new Date());
        product.setIsDel(0);
        product.setUpdateDate(new Date());
        productDao.addProduct(product);
    }
}
