package com.huanyuenwei.com.service.user.impl;

import com.huanyuenwei.com.dao.user.UserMapper;
import com.huanyumanagement.dao.user.model.User;
import com.huanyuenwei.com.dao.user.model.UserEntity;
import com.huanyuenwei.com.dao.user.req.UserReq;
import com.huanyuenwei.com.service.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 用户表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findByIds(List<String> ids) {
        UserEntity userEntity = new UserEntity();
        userEntity.createCriteria().andUserIdIn(ids);
        return userMapper.selectByEntity(userEntity);
    }

    @Override
    public String create(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        userMapper.insertSelective(user);
        return user.getUserId();
    }

    @Override
    public void deleteById(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UserEntity userEntity = new UserEntity();
        userEntity.createCriteria().andUserIdIn(ids);
        userMapper.deleteByEntity(userEntity);
    }

    @Override
    public void updateById(UserReq req) {
        User user = new User();
        BeanUtils.copyProperties(req, user);
        int result = userMapper.updateByPrimaryKeySelective(user);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}