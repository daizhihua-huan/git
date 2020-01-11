package com.huanyuenwei.com.dao.role;

import com.huanyumanagement.dao.role.model.Role;
import com.huanyuenwei.com.dao.role.model.RoleEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByEntity(RoleEntity entity);

    int deleteByEntity(RoleEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByEntity(RoleEntity entity);

    Role selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") Role record, @Param("entity") RoleEntity entity);

    int updateByEntity(@Param("record") Role record, @Param("entity") RoleEntity entity);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}