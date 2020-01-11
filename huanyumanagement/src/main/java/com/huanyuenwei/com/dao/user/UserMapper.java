package com.huanyuenwei.com.dao.user;

import com.huanyumanagement.dao.user.model.User;
import com.huanyuenwei.com.dao.user.model.UserEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByEntity(UserEntity entity);

    int deleteByEntity(UserEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByEntityWithBLOBs(UserEntity entity);

    List<User> selectByEntity(UserEntity entity);

    User selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") User record, @Param("entity") UserEntity entity);

    int updateByEntityWithBLOBs(@Param("record") User record, @Param("example") UserEntity entity);

    int updateByEntity(@Param("record") User record, @Param("entity") UserEntity entity);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}