package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.vo.PageParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ProductDao {
    @Insert("insert into shop_product (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) value (#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    void addProduct(Product product);

    @Update("update shop_product set name=#{name},title=#{title},bandId=#{bandId},typeId=#{typeId},productdecs=#{productdecs},price=#{price},imgPath=#{imgPath},stocks=#{stocks},sortNum=#{sortNum},createDate=#{createDate},updateDate=#{updateDate},author=#{author},isDel=#{isDel}")
    void updatePro(Product product);

    Long queryCount(PageParams vo);

    List<Product> queryProData(PageParams vo);
}
