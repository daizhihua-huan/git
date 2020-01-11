package com.huanyuenwei.com.dao.rolesDepts;

import com.huanyumanagement.dao.rolesDepts.model.RolesDepts;
import com.huanyuenwei.com.dao.rolesDepts.model.RolesDeptsEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesDeptsMapper {
    int countByEntity(RolesDeptsEntity entity);

    int deleteByEntity(RolesDeptsEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(RolesDepts record);

    int insertSelective(RolesDepts record);

    List<RolesDepts> selectByEntity(RolesDeptsEntity entity);

    RolesDepts selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") RolesDepts record, @Param("entity") RolesDeptsEntity entity);

    int updateByEntity(@Param("record") RolesDepts record, @Param("entity") RolesDeptsEntity entity);

    int updateByPrimaryKeySelective(RolesDepts record);

    int updateByPrimaryKey(RolesDepts record);
}