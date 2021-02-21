package com.fh.shop_behind.dao;



import com.fh.shop_behind.entity.po.Menu;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.xml.ws.soap.Addressing;
import java.util.List;
import java.util.Map;

public interface MenuDao {

    @Update("update a_menu set isDel=1 where id=#{id}")
    void delMenus(Integer id);

    @Update("update a_menu set pid=#{pid},name=#{name},url=#{url},author=#{author} where id=#{id}")
    void updateMenus(Menu menu);

    @Insert("insert into a_menu (pid,name,url,author,createdDate,isDel,type) value (#{pid},#{name},#{url},#{author},#{createdDate},#{isDel},#{type})")
    void addMenus(Menu menu);

    @Select("select * from a_menu")
    List<Menu> selectMenuData();

    @Select("select * from a_menu where id=#{id}")
    Map selectMenuById(Integer id);
}
