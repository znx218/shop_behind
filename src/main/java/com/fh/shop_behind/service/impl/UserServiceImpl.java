package com.fh.shop_behind.service.impl;

import com.fh.shop_behind.dao.UserDao;
import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.vo.PageParams;
import com.fh.shop_behind.service.UserService;
import com.fh.shop_behind.utils.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

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

   /* @Override
    public void addUser(User user) {
        user.setCreateDate(new Date());
        user.setUpdateDate(new Date());
        userDao.addUser(user);
    }*/
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
                request.getSession().setAttribute("login_user",user);
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


}
