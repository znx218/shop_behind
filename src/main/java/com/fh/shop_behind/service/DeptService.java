package com.fh.shop_behind.service;


import com.fh.shop_behind.entity.po.Dept;

import java.util.List;
import java.util.Map;

public interface DeptService {


    /*Map addDept(String name);

    Map updateDept(User user);*/

    List<Dept> selectDept();
}
