package com.fh.shop_behind.dao;

import com.fh.shop_behind.entity.po.UserRole;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

public interface UserRoleDao {
    @Select("select * from user_role where uid=#{id}")
    List<UserRole> selectRidByUid(Integer id);


    @Insert("<script>insert into user_role (uid,rid) values" +
            "<foreach collection='list' item='data' separator=','>" +
            "(#{data.uid},#{data.rid})</foreach></script>")
    void addUserRole(List<UserRole> list);

    @Delete("delete from user_role where uid=#{uid}")
    void delUserRole(Integer uid);
}