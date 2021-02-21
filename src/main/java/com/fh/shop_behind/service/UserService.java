package com.fh.shop_behind.service;

import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.vo.PageParams;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map queryUserByPage(PageParams vo);


    Map addUser(User user);

    List<User> queryEdui();

    Map loginUser(String name, String password);

    void updateUser(User user);

    Map selectUserById(Integer id);



}
