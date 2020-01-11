package com.huanyuenwei.com.service.usersRoles.impl;

import com.huanyuenwei.com.dao.usersRoles.UsersRolesMapper;
import com.huanyumanagement.dao.usersRoles.model.UsersRoles;
import com.huanyuenwei.com.dao.usersRoles.model.UsersRolesEntity;
import com.huanyuenwei.com.dao.usersRoles.req.UsersRolesReq;
import com.huanyuenwei.com.service.usersRoles.UsersRolesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

import java.math.BigDecimal;

/**
 * 用户角色表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class UsersRolesServiceImpl implements UsersRolesService {

    @Autowired
    private UsersRolesMapper usersRolesMapper;

    @Override
    public UsersRoles findById(Long id) {
        return usersRolesMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UsersRoles> findByIds(List<Long> ids) {
        UsersRolesEntity usersRolesEntity = new UsersRolesEntity();
        usersRolesEntity.createCriteria().andUserIdIn(ids);
        return usersRolesMapper.selectByEntity(usersRolesEntity);
    }

    @Override
    public Long create(UsersRolesReq req) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyProperties(req, usersRoles);
        usersRolesMapper.insertSelective(usersRoles);
        return usersRoles.getUserId();
    }

    @Override
    public void deleteById(Long id) {
        usersRolesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        UsersRolesEntity usersRolesEntity = new UsersRolesEntity();
        usersRolesEntity.createCriteria().andUserIdIn(ids);
        usersRolesMapper.deleteByEntity(usersRolesEntity);
    }

    @Override
    public void updateById(UsersRolesReq req) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyProperties(req, usersRoles);
        int result = usersRolesMapper.updateByPrimaryKeySelective(usersRoles);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}