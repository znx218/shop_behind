package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Product;
import org.apache.ibatis.annotations.Insert;

public interface ProductDao {
    @Insert("insert into shop_product (name,title,bandId,typeId,productdecs,price,imgPath,stocks,sortNum,createDate,updateDate,author,isDel) value (#{name},#{title},#{bandId},#{typeId},#{productdecs},#{price},#{imgPath},#{stocks},#{sortNum},#{createDate},#{updateDate},#{author},#{isDel})")
    void addProduct(Product product);
}
