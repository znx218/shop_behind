package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.User;
import com.fh.shop_behind.entity.vo.PageParams;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.relational.core.sql.In;

import java.util.List;
import java.util.Map;

public interface UserDao {
    Long queryCount(PageParams vo);

    List<User> queryUser(PageParams vo);


    User selectUserByName(String name);

    void addUser(User user);

    @Select("select * from a_user ")
    List<User> queryEdui();


    @Update("update a_user set realName=#{realName},sex=#{sex},phone=#{phone},email=#{email},birthday=#{birthday},imgUrl=#{imgUrl},eduId=#{eduId},deptId=#{deptId} where id=#{id}")
    void updateUser(User user);

    @Select("select * from a_user where id=#{id}")
    Map selectUserById(Integer id);


}
