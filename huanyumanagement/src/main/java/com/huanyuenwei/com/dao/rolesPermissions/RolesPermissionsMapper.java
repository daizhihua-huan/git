package com.huanyuenwei.com.dao.rolesPermissions;

import com.huanyumanagement.dao.rolesPermissions.model.RolesPermissions;
import com.huanyuenwei.com.dao.rolesPermissions.model.RolesPermissionsEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPermissionsMapper {
    int countByEntity(RolesPermissionsEntity entity);

    int deleteByEntity(RolesPermissionsEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(RolesPermissions record);

    int insertSelective(RolesPermissions record);

    List<RolesPermissions> selectByEntity(RolesPermissionsEntity entity);

    RolesPermissions selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") RolesPermissions record, @Param("entity") RolesPermissionsEntity entity);

    int updateByEntity(@Param("record") RolesPermissions record, @Param("entity") RolesPermissionsEntity entity);

    int updateByPrimaryKeySelective(RolesPermissions record);

    int updateByPrimaryKey(RolesPermissions record);
}