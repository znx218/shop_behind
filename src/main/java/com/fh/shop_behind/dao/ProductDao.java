package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.po.ProductAttrData;
import com.fh.shop_behind.entity.vo.PageParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Insert("insert into shop_product (name,title,brandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) value (#{name},#{title},#{brandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addProduct(Product product);

    @Update("update shop_product set name=#{name},title=#{title},brandId=#{brandId},typeId=#{typeId},productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},updateDate=#{updateDate},author=#{author},isDel=#{isDel} where id=#{id}")
    void updatePro(Product product);

    Long queryCount(PageParams vo);

    List<Product> queryProData(PageParams vo);

    @Update("update shop_product set isDel=#{isDel} where id=#{id}")
    void delProduct(Product product);


}
