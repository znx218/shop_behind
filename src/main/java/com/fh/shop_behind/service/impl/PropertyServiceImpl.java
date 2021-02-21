package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.PropertyDao;
import com.fh.shop_behind.dao.ValueDao;
import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.po.Value;
import com.fh.shop_behind.entity.vo.ProParmValue;
import com.fh.shop_behind.entity.vo.PropertyParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Period;
import java.util.*;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    private PropertyDao propertyDao;//属性表

    @Resource
    private ValueDao valueDao;//属性值表

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
        property.setAuthor("李二");
        property.setCreateDate(new Date());
        property.setUpdateDate(new Date());
        property.setIsDel(0);
        propertyDao.addPro(property);

    }

    @Override
    public void delPro(Integer id) {
        propertyDao.delPro(id);
    }

    @Override
    public void updatePro(Property property) {
        property.setUpdateDate(new Date());
        propertyDao.updatePro(property);

    }

    @Override
    public List<Property> queryProValueBytypeId(Integer typeId) {
        List<Property> list=propertyDao.queryProValueBytypeId(typeId);
        return list;
    }

    @Override
    public Map selectShopProDataByTypeId(Integer typeId) {
        Map map=new HashMap();

        List<ProParmValue> list=propertyDao.selectShopProIsSku(typeId);
        for (int i = 0; i <list.size() ; i++) {
            List<Value> proValues = valueDao.selectProValueDataByproId(list.get(i).getId());//通过属性id查询所有sku属性值
            list.get(i).setValues(proValues);
            List list3=new ArrayList();
            list.get(i).setCkValues(list3);
        }

        List<ProParmValue> list2=propertyDao.selectShopProNoIsSku(typeId);

        for (ProParmValue proParmValue : list2) {
            List<Value> proValues = valueDao.selectProValueDataByproId(proParmValue.getId());//通过属性id查询所有非sku属性值
            proParmValue.setValues(proValues);
            List list4=new ArrayList();
            proParmValue.setCkValues(list4);
        }


        map.put("SKUData",list);
        map.put("attData",list2);
        return map;
    }


}
