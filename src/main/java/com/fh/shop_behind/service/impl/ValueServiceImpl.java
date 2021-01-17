package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.ValueDao;
import com.fh.shop_behind.entity.po.Value;
import com.fh.shop_behind.service.ValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ValueServiceImpl implements ValueService {
    @Resource
    private ValueDao valueDao;

    @Override
    public List<Value> queryValue(Integer proId) {
        List<Value> list=valueDao.queryValue(proId);
        return list;
    }

    @Override
    public void addValue(Value va) {
        valueDao.addValue(va);
    }

    @Override
    public void updateValue(Value va) {
        valueDao.updateValue(va);
    }

    @Override
    public void delValue(Integer id) {
        valueDao.delValue(id);
    }
}
