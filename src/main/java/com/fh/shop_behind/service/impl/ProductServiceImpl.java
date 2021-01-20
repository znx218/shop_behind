package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.ProductDao;
import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    @Override
    public void addProduct(Product product) {
        product.setAuthor("znx");
        product.setCreateDate(new Date());
        product.setIsDel(0);
        product.setUpdateDate(new Date());
        productDao.addProduct(product);
    }

    @Override
    public void updatePro(Product product) {
        product.setAuthor("znx");
        product.setUpdateDate(new Date());
        productDao.updatePro(product);

    }

    @Override
    public Map queryProduct(PageParams vo) {
        Map map=new HashMap();
        //查询总条数
        Long count=productDao.queryCount(vo);
        map.put("count",count);
        //查询每页数据
        List<Product> list=productDao.queryProData(vo);
        map.put("list",list);
        return map;
    }
}
