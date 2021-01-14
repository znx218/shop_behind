package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Brand;
import com.fh.shop_behind.entity.vo.BrandParams;

import java.util.List;

public interface BrandDao {
    Long queryCount(BrandParams vo);

    List<Brand> queryBrand(BrandParams vo);

    void addBrand(Brand br);


    void updateBrand(Brand br);
}
