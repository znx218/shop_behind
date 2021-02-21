package com.fh.shop_behind.controller;


import com.fh.shop_behind.entity.po.Menu;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.MenuService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("menu/")
@CrossOrigin
public class MenuController {
    @Resource
    private MenuService menuService;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/selectMenuData
     * 请求方式：get
     * */
    @GetMapping("selectMenuData")
    public ResultData selectMenuData(){//查询权限
       List<Menu> menulist = menuService.selectMenuData();
       return ResultData.success(menulist);
    }



    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/addMenus
     * 请求方式：post
     * */
    @PostMapping("addMenus")
    public ResultData addMenus(Menu menu){
        menuService.addMenus(menu);
        return ResultData.success("");
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/delMenus
     * 请求方式：post
     * */
    @PostMapping("delMenus")
    public ResultData delMenus(Integer id){
        menuService.delMenus(id);
        return ResultData.success("");
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/updateMenus
     * 请求方式：post
     * */
    @PostMapping("updateMenus")
    public ResultData updateMenus(Menu menu){
        menuService.updateMenus(menu);
        return ResultData.success("");
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/selectMenuById
     * 请求方式：get
     * */
    @GetMapping("selectMenuById")
    public ResultData selectMenuById(Integer id){
        Map map=menuService.selectMenuById(id);
        return ResultData.success(map);
    }

    /*@PostMapping("delOrAddRoleMenu")
    public Map delOrAddRoleMenu(Integer rid,String mids){
        Map map=menuService.delOrAddRoleMenu(rid,mids);
        return map;
    }*/
}
