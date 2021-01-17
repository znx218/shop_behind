package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.Value;

import java.util.List;

public interface ValueService {
    List<Value> queryValue(Integer proId);

    void addValue(Value va);

    void updateValue(Value va);
}
