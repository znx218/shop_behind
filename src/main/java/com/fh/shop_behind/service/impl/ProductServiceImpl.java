package com.fh.shop_behind.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fh.shop_behind.dao.ProductAttrDataDao;
import com.fh.shop_behind.dao.ProductDao;
import com.fh.shop_behind.entity.po.Product;
import com.fh.shop_behind.entity.po.ProductAttrData;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private ProductAttrDataDao productAttrDataDao;

    @Override
    @Transactional  //加上事务
    public void addProduct(Product product,String attr,String sku) {
        //商品新增 分两页：第①页 商品表 第二页：sku数据 和 非sku数据
        //返回主键
        productDao.addProduct(product);//第一页数据

        //声明属性数据对象 的集合
        List<ProductAttrData> palist=new ArrayList<>();
        //进行批量新增
        //将非sku数据json数组字符串  转为json数组对象
        JSONArray objects = JSONObject.parseArray(attr);
        for (int i = 0; i <objects.size() ; i++) {
            //构建属性数据对象
            ProductAttrData a=new ProductAttrData();
            //设置对应的商品id
            a.setProId(product.getId());
            a.setAttrData(objects.get(i).toString());
            //放入集合
            palist.add(a);
        }

        //将sku的json数组字符串 转为json数组对象
        JSONArray objectssku = JSONObject.parseArray(sku);
        for (int i = 0; i <objectssku.size() ; i++) {
            //得到具体一个json对象
            JSONObject dataJs= (JSONObject) objectssku.get(i);
            //构建属性数据对象
            ProductAttrData b=new ProductAttrData();
            //设置对应的商品id
            b.setProId(product.getId());
            b.setPrice(dataJs.getDouble("price"));
            b.setStocks(dataJs.getInteger("stocks"));
            dataJs.remove("price");
            dataJs.remove("stocks");
            b.setAttrData(objectssku.get(i).toString());
            //放入集合
            palist.add(b);
        }
        //新增非sku  sku
        productAttrDataDao.adds(palist);
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

    @Override
    public void delProduct(Product product) {
        productDao.delProduct(product);
    }

    @Override
    public List<ProductAttrData> queryDataByProId(Integer proId) {
        List<ProductAttrData> list= productAttrDataDao.queryDataByProId(proId);
        return list;
    }


}
