package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Property;
import com.fh.shop_behind.entity.vo.ProParmValue;
import com.fh.shop_behind.entity.vo.PropertyParams;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface PropertyDao {
    Long queryCount(PropertyParams vo);

    List<Property> queryProperty(PropertyParams vo);

    void addPro(Property property);

    @Update("update shop_property set isDel=1 where id=#{id}")
    void delPro(Integer id);

    void updatePro(Property property);

    @Select("select * from  shop_property where typeId=#{typeId}")
    List<Property> queryProValueBytypeId(Integer typeId);




    @Select("select * from shop_property where typeId=#{typeId}  and isSKU=0")
    List<ProParmValue> selectShopProIsSku(Integer typeId);

    @Select("select * from shop_property where typeId=#{typeId}  and isSKU=1")
    List<ProParmValue> selectShopProNoIsSku(Integer typeId);
}
