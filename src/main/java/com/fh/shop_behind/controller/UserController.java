package com.fh.shop_behind.controller;

import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.entity.vo.ResultData;
import com.fh.shop_behind.service.UserService;
import com.fh.shop_behind.utils.OssFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user/")
@CrossOrigin
public class UserController {
    @Resource
    private UserService userService;

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
