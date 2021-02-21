package com.fh.shop_behind.dao;


import com.fh.shop_behind.entity.po.Dept;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DeptDao {

    /*void addDept(String name);

    void updateDept(User user);*/

    @Select("select * from a_dept")
    List<Dept> selectDept();
}
