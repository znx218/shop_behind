package com.fh.shop_behind.service.impl;


import com.fh.shop_behind.dao.BrandDao;
import com.fh.shop_behind.entity.po.Brand;
import com.fh.shop_behind.entity.vo.BrandParams;
import com.fh.shop_behind.service.BrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {
    @Resource
    private BrandDao brandDao;

    @Override
    public Map queryBrandByPage(BrandParams vo) {
        Map map=new HashMap();
        //查询总条数
        Long count = brandDao.queryCount(vo);
        map.put("count",count);
        //查询分页数据
        //查询数据
        List<Brand> list=brandDao.queryBrand(vo);
        map.put("list",list);
        return map;
    }

    @Override
    public void addBrand(Brand br) {
        br.setCreateDate(new Date());
        br.setUpdateDate(new Date());
        br.setIsDel(0);
        br.setAuthor("China造");
        brandDao.addBrand(br);
    }

    @Override
    public void updateBrand(Brand br) {
        br.setUpdateDate(new Date());
        brandDao.updateBrand(br);
    }

    @Override
    public List<Brand> queryBrand() {
        List<Brand> list=brandDao.queryBrandData();
        return list;
    }


}
