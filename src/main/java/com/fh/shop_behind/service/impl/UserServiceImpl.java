package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.RoleDao;
import com.fh.shop_behind.dao.UserDao;
import com.fh.shop_behind.dao.UserRoleDao;
import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.po.UserRole;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.service.UserService;
import com.fh.shop_behind.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Resource
    private RoleDao roleDao;

    @Resource
    private UserRoleDao userRoleDao;



    @Resource
    private HttpServletRequest request;

    @Override
    public Map queryUserByPage(PageParams vo) {
        Map map=new HashMap();
        //查询总条数
        Long count =userDao.queryCount(vo);
        map.put("count",count);
        //查询每页数据
        List<User> list=userDao.queryUser(vo);
        map.put("list",list);
        return map;
    }


   @Override
   public Map addUser(User user) {
       Map map=new HashMap();
       User user1=userDao.selectUserByName(user.getName());
       if(user1==null){
           String encoder = MD5Util.encoder(MD5Util.encoder(user.getName()) + MD5Util.encoder(user.getPassword()));
           user.setCreateDate(new Date());
           user.setUpdateDate(new Date());
           user.setPassword(encoder);
           userDao.addUser(user);
           map.put("status",3);
       }else{
           map.put("status",1);
       }
       return map;
   }

    @Override
    public List<User> queryEdui() {
       List<User> list=userDao.queryEdui();
        return list;
    }

    @Override
    public Map loginUser(String name,String password) {
        Map map=new HashMap();
        User user = userDao.selectUserByName(name);//登录去验证用户是否存在
        if(user!=null){//如果用户存在
            String encoder = MD5Util.encoder(MD5Util.encoder(name) + MD5Util.encoder(password));
            if(user.getPassword().equals(encoder)){
                map.put("status",3);//登录成功
                request.getSession().setAttribute("login_user",user);//把用户信息放入session中保存
            }else{
                map.put("status",2);//密码错误
            }
        }else{
            map.put("status",1);//否则用户不存在
        }
        return map;
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Map selectUserById(Integer id) {
        Map map=userDao.selectUserById(id);
        return map;
    }

    @Override
    @Transactional  //有一个方法不执行就会回调
    public Map selectRidByUid(Integer id) {
       Map map=new HashMap();
        List<UserRole> list=userRoleDao.selectRidByUid(id);
        List<Role> roles = roleDao.selectAllRole();
        map.put("list",list);//用户拥有的角色
        map.put("roles",roles);//所有的角色
        return map;
    }

    @Override
    @Transactional
    public void delOrfuRole(Integer uid, String ckRoles) {
        //保存前先删除数据  避免重复保存
        userRoleDao.delUserRole(uid);

        //创建一个集合 用来存放数据
        List<UserRole> list=new ArrayList<>();
        //ckRoles是字符串 "1,2,3,4," 进行批量新增 1,2,3,4
        String[] split = ckRoles.split(",");
        for (int i = 0; i <split.length ; i++) {
            UserRole ur=new UserRole();
            ur.setUid(uid);
            ur.setRid(Integer.parseInt(split[i]));
            list.add(ur);
        }
        userRoleDao.addUserRole(list);
    }


}
