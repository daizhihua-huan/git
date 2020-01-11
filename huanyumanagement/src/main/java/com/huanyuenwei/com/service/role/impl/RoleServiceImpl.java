package com.huanyuenwei.com.service.role.impl;

import com.huanyuenwei.com.dao.role.RoleMapper;
import com.huanyumanagement.dao.role.model.Role;
import com.huanyuenwei.com.dao.role.model.RoleEntity;
import com.huanyuenwei.com.dao.role.req.RoleReq;
import com.huanyuenwei.com.service.role.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 角色表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role findById(String id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> findByIds(List<String> ids) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.createCriteria().andRoleIdIn(ids);
        return roleMapper.selectByEntity(roleEntity);
    }

    @Override
    public String create(RoleReq req) {
        Role role = new Role();
        BeanUtils.copyProperties(req, role);
        roleMapper.insertSelective(role);
        return role.getRoleId();
    }

    @Override
    public void deleteById(String id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.createCriteria().andRoleIdIn(ids);
        roleMapper.deleteByEntity(roleEntity);
    }

    @Override
    public void updateById(RoleReq req) {
        Role role = new Role();
        BeanUtils.copyProperties(req, role);
        int result = roleMapper.updateByPrimaryKeySelective(role);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}