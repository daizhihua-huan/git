package com.huanyuenwei.com.service.permission.impl;

import com.huanyuenwei.com.dao.permission.PermissionMapper;
import com.huanyumanagement.dao.permission.model.Permission;
import com.huanyuenwei.com.dao.permission.model.PermissionEntity;
import com.huanyuenwei.com.dao.permission.req.PermissionReq;
import com.huanyuenwei.com.service.permission.PermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 权限表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public Permission findById(String id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> findByIds(List<String> ids) {
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.createCriteria().andPermissionIdIn(ids);
        return permissionMapper.selectByEntity(permissionEntity);
    }

    @Override
    public String create(PermissionReq req) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(req, permission);
        permissionMapper.insertSelective(permission);
        return permission.getPermissionId();
    }

    @Override
    public void deleteById(String id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        PermissionEntity permissionEntity = new PermissionEntity();
        permissionEntity.createCriteria().andPermissionIdIn(ids);
        permissionMapper.deleteByEntity(permissionEntity);
    }

    @Override
    public void updateById(PermissionReq req) {
        Permission permission = new Permission();
        BeanUtils.copyProperties(req, permission);
        int result = permissionMapper.updateByPrimaryKeySelective(permission);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}