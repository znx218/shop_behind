package com.fh.shop_behind.service;


import com.fh.shop_behind.entity.po.Brand;
import com.fh.shop_behind.entity.vo.BrandParams;

import java.util.List;
import java.util.Map;

public interface BrandService {
    Map queryBrandByPage(BrandParams vo);

    void addBrand(Brand br);

    void updateBrand(Brand br);


    List<Brand> queryBrand();
}
