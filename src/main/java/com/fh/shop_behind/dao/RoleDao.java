package com.fh.shop_behind.dao;



import com.fh.shop_behind.entity.po.Role;
import com.fh.shop_behind.entity.vo.PageParams;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface RoleDao {



    Long queryRoleCount(PageParams vo);

    List<Role> queryRole(PageParams vo);

    @Insert("insert into a_role (name,isDel,createdDate,author) value (#{name},#{isDel},#{createdDate},#{author})")
    void addRole(Role role);
    @Update("update a_role set isDel=1 where id=#{id}")
    void delRole(Integer id);
    @Update("update a_role set name=#{name},author=#{author} where id=#{id}")
    void updateRole(Role role);
    @Select("select * from a_role where id=#{id}")
    Map selectRoleById(Integer id);
}
