package com.fh.shop_behind.service;



import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.vo.PageParams;

import java.util.List;
import java.util.Map;

public interface RoleService {


    Map selectByPage(PageParams vo);

    void addRole(Role role);

    void delRole(Integer id);

    void updateRole(Role role);

    Map selectRoleById(Integer id);

    List<Role> selectAllRole();

}
