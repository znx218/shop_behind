package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Value;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ValueDao {
    @Select("select * from shop_property_value where proId=#{proId}")
    List<Value> queryValue(Integer proId);

    @Insert("insert into shop_property_value (value,valueZhi,proId)" +
            "value (#{value},#{valueZhi},#{proId})")
    void addValue(Value va);
}
