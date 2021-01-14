package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.PropertyParams;

import java.util.Map;

public interface PropertyService {
    Map queryPro(PropertyParams vo);


    void addPro(Property property);

    void delPro(Integer id);
}
