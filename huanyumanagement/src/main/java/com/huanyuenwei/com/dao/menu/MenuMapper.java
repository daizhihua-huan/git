package com.huanyuenwei.com.dao.menu;

import com.huanyumanagement.dao.menu.model.Menu;
import com.huanyuenwei.com.dao.menu.model.MenuEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    int countByEntity(MenuEntity entity);

    int deleteByEntity(MenuEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByEntity(MenuEntity entity);

    Menu selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") Menu record, @Param("entity") MenuEntity entity);

    int updateByEntity(@Param("record") Menu record, @Param("entity") MenuEntity entity);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}