package com.huanyuenwei.com.dao.permission;

import com.huanyumanagement.dao.permission.model.Permission;
import com.huanyuenwei.com.dao.permission.model.PermissionEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PermissionMapper {
    int countByEntity(PermissionEntity entity);

    int deleteByEntity(PermissionEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByEntity(PermissionEntity entity);

    Permission selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") Permission record, @Param("entity") PermissionEntity entity);

    int updateByEntity(@Param("record") Permission record, @Param("entity") PermissionEntity entity);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}