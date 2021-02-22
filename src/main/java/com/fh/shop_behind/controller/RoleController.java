package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.RoleService;
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
@RequestMapping("role/")
@CrossOrigin
public class RoleController {
    @Resource
    private RoleService roleService;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

   /*@RequestMapping("delOrAddUserRole")
    @ResponseBody
    public Map delOrAddUserRole(Integer uid,String rids){
       Map map=roleService.delOrAddUserRole(uid,rids);
       return map;
   }*/


    /*
     * 接口文档
     * 路径：http://localhost:8080/role/selectRoleByPage
     * 请求方式：get
     * */
    @GetMapping("selectRoleByPage")
    public ResultData selectByPage(PageParams vo){
        if(vo.getCurrPage()==null){
            return ResultData.error(500,"参数错误");
        }
        if(vo.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=roleService.selectByPage(vo);
        return ResultData.success(map);
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/role/addRole
     * 请求方式：post
     * */
    @PostMapping("addRole")
    public ResultData addRole(Role role){
        roleService.addRole(role);
        return ResultData.success("");
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/role/delRole
     * 请求方式：get
     * */
    @GetMapping("delRole")
    public ResultData delRole(Integer id){
        roleService.delRole(id);
        return  ResultData.success("");
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/role/updateRole
     * 请求方式：post
     * */
    @PostMapping("updateRole")
    public ResultData updateRole(Role role){
        roleService.updateRole(role);
        return ResultData.success("");
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/menu/selectRoleById
     * 请求方式：get
     * */
    @GetMapping("selectRoleById")
    public ResultData selectRoleById(Integer id){
        Map map=roleService.selectRoleById(id);
        return ResultData.success(map);
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/user/selectAllRole
     * 请求方式：get
     * */
    @GetMapping("selectAllRole")
    public ResultData selectAllRole(){
        List<Role> list=roleService.selectAllRole();
        return ResultData.success(list);
    }
}
