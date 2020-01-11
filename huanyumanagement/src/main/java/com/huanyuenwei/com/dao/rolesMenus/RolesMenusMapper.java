package com.huanyuenwei.com.dao.rolesMenus;

import com.huanyumanagement.dao.rolesMenus.model.RolesMenus;
import com.huanyuenwei.com.dao.rolesMenus.model.RolesMenusEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMenusMapper {
    int countByEntity(RolesMenusEntity entity);

    int deleteByEntity(RolesMenusEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(RolesMenus record);

    int insertSelective(RolesMenus record);

    List<RolesMenus> selectByEntity(RolesMenusEntity entity);

    RolesMenus selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") RolesMenus record, @Param("entity") RolesMenusEntity entity);

    int updateByEntity(@Param("record") RolesMenus record, @Param("entity") RolesMenusEntity entity);

    int updateByPrimaryKeySelective(RolesMenus record);

    int updateByPrimaryKey(RolesMenus record);
}