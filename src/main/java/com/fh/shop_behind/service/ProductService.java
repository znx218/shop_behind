package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.po.ProductAttrData;
import com.fh.shop_behind.entity.vo.PageParams;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void addProduct(Product product,String attr,String sku);

    void updatePro(Product product);

    Map queryProduct(PageParams params);

    void delProduct(Product product);

    List<ProductAttrData> queryDataByProId(Integer proId);
}
