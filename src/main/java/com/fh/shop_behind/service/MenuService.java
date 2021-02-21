package com.fh.shop_behind.service;
import com.fh.shop_behind.entity.po.Menu;

import java.util.List;
import java.util.Map;

public interface MenuService {


    void delMenus(Integer id);

    void updateMenus(Menu menu);

    void addMenus(Menu menu);


    List<Menu> selectMenuData();

    Map selectMenuById(Integer id);
}
