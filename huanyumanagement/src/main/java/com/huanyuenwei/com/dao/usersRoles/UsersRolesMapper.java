package com.huanyuenwei.com.dao.usersRoles;

import com.huanyumanagement.dao.usersRoles.model.UsersRoles;
import com.huanyuenwei.com.dao.usersRoles.model.UsersRolesEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersRolesMapper {
    int countByEntity(UsersRolesEntity entity);

    int deleteByEntity(UsersRolesEntity entity);

    int deleteByPrimaryKey(Long id);

    int insert(UsersRoles record);

    int insertSelective(UsersRoles record);

    List<UsersRoles> selectByEntity(UsersRolesEntity entity);

    UsersRoles selectByPrimaryKey(Long id);

    int updateByEntitySelective(@Param("record") UsersRoles record, @Param("entity") UsersRolesEntity entity);

    int updateByEntity(@Param("record") UsersRoles record, @Param("entity") UsersRolesEntity entity);

    int updateByPrimaryKeySelective(UsersRoles record);

    int updateByPrimaryKey(UsersRoles record);
}