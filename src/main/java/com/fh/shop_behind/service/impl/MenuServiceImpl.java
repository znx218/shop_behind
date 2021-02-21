package com.fh.shop_behind.service.impl;


import com.fh.shop_behind.dao.MenuDao;
import com.fh.shop_behind.entity.po.Menu;
import com.fh.shop_behind.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    private MenuDao menuDao;
     /*@Resource
    private RoleMenuDao roleMenuDao;*/

    @Override
    public void delMenus(Integer id) {
        menuDao.delMenus(id);
    }

    @Override
    public void updateMenus(Menu menu) {
        menu.setAuthor("小飞侠");
        menuDao.updateMenus(menu);
    }

    @Override
    public void addMenus(Menu menu) {
        menu.setCreatedDate(new Date());
        menu.setAuthor("小飞侠");
        menuDao.addMenus(menu);
    }

    @Override
    public List<Menu> selectMenuData() {
        List<Menu> menulist=menuDao.selectMenuData();
        return menulist;
    }

    @Override
    public Map selectMenuById(Integer id) {
        Map map=menuDao.selectMenuById(id);
        return map;
    }


}
