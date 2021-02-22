package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.po.UserRole;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.UserService;
import com.fh.shop_behind.utils.OssFile;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user/")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

    @InitBinder
    protected void init(HttpServletRequest request, ServletRequestDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
    /*
     * 接口文档
     * 路径：http://localhost:8080/user/queryUserByPage
     * 请求方式：get
     * */
    @GetMapping("queryUserByPage")
    public ResultData queryUserByPage(PageParams vo){
        if(vo.getCurrPage()==null){
            return ResultData.error(500,"参数错误");
        }
        if(vo.getSize()==null){
            return ResultData.error(500,"参数错误");
        }
        Map map=userService.queryUserByPage(vo);
        return ResultData.success(map);

    }




    /*
     * 接口文档
     * 路径：http://localhost:8080/user/updateUser
     * 请求方式：post
     * */
    @PostMapping("updateUser")
    public ResultData updateUser(User user){
        userService.updateUser(user);
        return ResultData.success("");
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/user/selectUserById
     * 请求方式：post
     * */
    @PostMapping("selectUserById")
    public ResultData selectUserById(Integer id){
        Map map=userService.selectUserById(id);
        return ResultData.success(map);
    }






    /*
     * 接口文档
     * 路径：http://localhost:8080/user/addUser
     * 请求方式：post
     * */
    @PostMapping("addUser")
    public Map addUser(User user){
        Map map=userService.addUser(user);
        return map;
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/user/loginUser
     * 请求方式：post
     * */
    @PostMapping("loginUser")
    public Map loginUser(String name,String password){
        Map map = userService.loginUser(name,password);
        return map;
    }


    /*
     * 接口文档
     * 查询用户拥有的角色
     * 路径：http://localhost:8080/user/selectRidByUid
     * 请求方式：get
     * */
    @GetMapping("selectRidByid")
    public ResultData selectRidByUid(Integer id){
        Map map=userService.selectRidByUid(id);
        return ResultData.success(map);
    }

    /*
     * 接口文档
     * 路径：http://localhost:8080/user/delOrfuRole
     * 请求方式：post
     * */
    @PostMapping("delOrfuRole")
    public ResultData delOrfuRole(Integer uid,String ckRoles){
        userService.delOrfuRole(uid,ckRoles);
        return ResultData.success("");
    }


    /*
     * 接口文档
     * 路径：http://localhost:8080/user/upload
     * 请求方式：post
     * */
    @PostMapping("upload")
    public ResultData upload(MultipartFile file) throws IOException {
        //处理新名称
        String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        //存储路径
        newName="imgs/"+newName;
        return ResultData.success(OssFile.uploadFile(file.getInputStream(),newName));
    }

}
