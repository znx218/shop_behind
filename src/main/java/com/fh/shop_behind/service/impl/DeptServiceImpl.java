package com.fh.shop_behind.service.impl;


import com.fh.shop_behind.dao.DeptDao;
import com.fh.shop_behind.entity.po.Dept;
import com.fh.shop_behind.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DeptServiceImpl implements DeptService {
        @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> selectDept() {
        List<Dept> list=deptDao.selectDept();
        return list;
    }



   /* @Override
    public Map addDept(String name) {
        Map map=new HashMap();
        deptDao.addDept(name);
        map.put("status",200);
        return map;
    }

    @Override
    public Map updateDept(User user) {
        Map map=new HashMap();
        deptDao.updateDept(user);
        map.put("status",200);
        return map;
    }*/


}
