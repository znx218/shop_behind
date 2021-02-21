package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.Edui;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EduiDao {

    @Select("select * from a_edui")
    List<Edui> selectEdui();

}
