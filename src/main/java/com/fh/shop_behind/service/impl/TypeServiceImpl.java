package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.TypeDao;
import com.fh.shop_behind.entity.po.Type;
import com.fh.shop_behind.service.TypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Resource
    private TypeDao typeDao;

    @Override
    public List<Type> getData() {
        List<Type> typeList=typeDao.getData();
        return typeList;
    }

    @Override
    public List<Type> getDataByPid(Integer pid) {
        List<Type> typeList=typeDao.getDataByPid(pid);
        return typeList;
    }

    @Override
    public int add(Type type) {
        type.setCreateDate(new Date());
        type.setIsDel(0);
        type.setUpdateDate(new Date());
        typeDao.add(type);
        return type.getId();
    }

    @Override
    public Type queryByType(Integer id) {
        Type type=typeDao.queryByType(id);
        return type;
    }

    @Override
    public void update(Type type) {
        type.setUpdateDate(new Date());
        type.setName("张三");
        typeDao.update(type);
    }


}
