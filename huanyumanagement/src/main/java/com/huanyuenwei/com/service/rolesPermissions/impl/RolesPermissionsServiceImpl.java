package com.huanyuenwei.com.service.rolesPermissions.impl;

import com.huanyuenwei.com.dao.rolesPermissions.RolesPermissionsMapper;
import com.huanyumanagement.dao.rolesPermissions.model.RolesPermissions;
import com.huanyuenwei.com.dao.rolesPermissions.model.RolesPermissionsEntity;
import com.huanyuenwei.com.dao.rolesPermissions.req.RolesPermissionsReq;
import com.huanyuenwei.com.service.rolesPermissions.RolesPermissionsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 角色权限表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class RolesPermissionsServiceImpl implements RolesPermissionsService {

    @Autowired
    private RolesPermissionsMapper rolesPermissionsMapper;

    @Override
    public RolesPermissions findById(String id) {
        return rolesPermissionsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RolesPermissions> findByIds(List<String> ids) {
        RolesPermissionsEntity rolesPermissionsEntity = new RolesPermissionsEntity();
        rolesPermissionsEntity.createCriteria().andRoleIdIn(ids);
        return rolesPermissionsMapper.selectByEntity(rolesPermissionsEntity);
    }

    @Override
    public String create(RolesPermissionsReq req) {
        RolesPermissions rolesPermissions = new RolesPermissions();
        BeanUtils.copyProperties(req, rolesPermissions);
        rolesPermissionsMapper.insertSelective(rolesPermissions);
        return rolesPermissions.getRoleId();
    }

    @Override
    public void deleteById(String id) {
        rolesPermissionsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RolesPermissionsEntity rolesPermissionsEntity = new RolesPermissionsEntity();
        rolesPermissionsEntity.createCriteria().andRoleIdIn(ids);
        rolesPermissionsMapper.deleteByEntity(rolesPermissionsEntity);
    }

    @Override
    public void updateById(RolesPermissionsReq req) {
        RolesPermissions rolesPermissions = new RolesPermissions();
        BeanUtils.copyProperties(req, rolesPermissions);
        int result = rolesPermissionsMapper.updateByPrimaryKeySelective(rolesPermissions);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}