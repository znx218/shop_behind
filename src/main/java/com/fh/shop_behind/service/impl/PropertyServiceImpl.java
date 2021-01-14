package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.PropertyDao;
import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.PropertyParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    private PropertyDao propertyDao;

    @Override
    public Map queryPro(PropertyParams vo) {
        Map map=new HashMap();
        //查询总条数
        Long count=propertyDao.queryCount(vo);
        map.put("count",count);
        //查询分页数据
        List<Property> list=propertyDao.queryProperty(vo);
        map.put("list",list);
        return map;
    }

    @Override
    public void addPro(Property property) {
        propertyDao.addPro(property);
        property.setAuthor("李二");
        property.setCreateDate(new Date());
        property.setUpdateDate(new Date());
    }

    @Override
    public void delPro(Integer id) {
        propertyDao.delPro(id);
    }


}
