package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Type;

import java.util.List;

public interface TypeDao {
    List<Type> getData();

    List<Type> getDataByPid(Integer pid);

    void add(Type type);

    Type queryByType(Integer id);

    void update(Type type);
}
