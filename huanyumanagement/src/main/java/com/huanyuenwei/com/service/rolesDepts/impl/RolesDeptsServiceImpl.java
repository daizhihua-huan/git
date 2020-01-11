package com.huanyuenwei.com.service.rolesDepts.impl;

import com.huanyuenwei.com.dao.rolesDepts.RolesDeptsMapper;
import com.huanyumanagement.dao.rolesDepts.model.RolesDepts;
import com.huanyuenwei.com.dao.rolesDepts.model.RolesDeptsEntity;
import com.huanyuenwei.com.dao.rolesDepts.req.RolesDeptsReq;
import com.huanyuenwei.com.service.rolesDepts.RolesDeptsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 角色部门表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class RolesDeptsServiceImpl implements RolesDeptsService {

    @Autowired
    private RolesDeptsMapper rolesDeptsMapper;

    @Override
    public RolesDepts findById(String id) {
        return rolesDeptsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RolesDepts> findByIds(List<String> ids) {
        RolesDeptsEntity rolesDeptsEntity = new RolesDeptsEntity();
        rolesDeptsEntity.createCriteria().andRoleIdIn(ids);
        return rolesDeptsMapper.selectByEntity(rolesDeptsEntity);
    }

    @Override
    public String create(RolesDeptsReq req) {
        RolesDepts rolesDepts = new RolesDepts();
        BeanUtils.copyProperties(req, rolesDepts);
        rolesDeptsMapper.insertSelective(rolesDepts);
        return rolesDepts.getRoleId();
    }

    @Override
    public void deleteById(String id) {
        rolesDeptsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RolesDeptsEntity rolesDeptsEntity = new RolesDeptsEntity();
        rolesDeptsEntity.createCriteria().andRoleIdIn(ids);
        rolesDeptsMapper.deleteByEntity(rolesDeptsEntity);
    }

    @Override
    public void updateById(RolesDeptsReq req) {
        RolesDepts rolesDepts = new RolesDepts();
        BeanUtils.copyProperties(req, rolesDepts);
        int result = rolesDeptsMapper.updateByPrimaryKeySelective(rolesDepts);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}