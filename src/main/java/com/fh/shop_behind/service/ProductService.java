package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.vo.PageParams;

import java.util.Map;

public interface ProductService {
    void addProduct(Product product);

    void updatePro(Product product);

    Map queryProduct(PageParams params);
}
