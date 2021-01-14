package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.Type;

import java.util.List;

public interface TypeService {
    List<Type> getData();

    List<Type> getDataByPid(Integer pid);

    int add(Type type);

    Type queryByType(Integer id);

    void update(Type type);

}
