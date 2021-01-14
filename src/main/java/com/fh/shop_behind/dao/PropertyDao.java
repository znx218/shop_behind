package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.PropertyParams;

import java.util.List;

public interface PropertyDao {
    Long queryCount(PropertyParams vo);

    List<Property> queryProperty(PropertyParams vo);

    void addPro(Property property);

    void delPro(Integer id);
}
