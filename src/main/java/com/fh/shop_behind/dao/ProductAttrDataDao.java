package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.ProductAttrData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductAttrDataDao {



    @Insert("<script>insert into shop_product_attrData (proId,attrData,stocks,price) " +
            "values <foreach collection='list' item='a' separator=','> ( #{a.proId},#{a.attrData},#{a.stocks},#{a.price} )  </foreach> </script>")
    void adds(List<ProductAttrData> palist);


    @Select("select * from shop_product_attrData where proId=#{proId}")
    List<ProductAttrData> queryDataByProId(Integer proId);

}
