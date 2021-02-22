package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.RoleDao;
import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.service.RoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class RoleServiceImpl implements RoleService {
    @Resource
    private RoleDao roleDao;
     /* @Resource
    private UserRoleDao userRoleDao;*/

    @Override
    public Map selectByPage(PageParams vo) {
        Map map=new HashMap();
        //查询总条数
        Long count=roleDao.queryRoleCount(vo);
        map.put("count",count);
        //查询每页数据
        List<Role> list=roleDao.queryRole(vo);
        map.put("list",list);
        return map;
    }

    @Override
    public void addRole(Role role) {
        role.setCreatedDate(new Date());
        role.setAuthor("小飞侠");
        roleDao.addRole(role);
    }

    @Override
    public void delRole(Integer id) {
        roleDao.delRole(id);
    }

    @Override
    public void updateRole(Role role) {
        role.setAuthor("小飞侠");
        roleDao.updateRole(role);
    }

    @Override
    public Map selectRoleById(Integer id) {
        Map map=roleDao.selectRoleById(id);
        return map;
    }

    @Override
    public List<Role> selectAllRole() {
        List<Role> list=roleDao.selectAllRole();
        return list;
    }


}
