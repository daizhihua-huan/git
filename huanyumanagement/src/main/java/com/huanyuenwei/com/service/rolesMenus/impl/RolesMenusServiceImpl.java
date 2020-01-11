package com.huanyuenwei.com.service.rolesMenus.impl;

import com.huanyuenwei.com.dao.rolesMenus.RolesMenusMapper;
import com.huanyumanagement.dao.rolesMenus.model.RolesMenus;
import com.huanyuenwei.com.dao.rolesMenus.model.RolesMenusEntity;
import com.huanyuenwei.com.dao.rolesMenus.req.RolesMenusReq;
import com.huanyuenwei.com.service.rolesMenus.RolesMenusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 角色菜单表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class RolesMenusServiceImpl implements RolesMenusService {

    @Autowired
    private RolesMenusMapper rolesMenusMapper;

    @Override
    public RolesMenus findById(String id) {
        return rolesMenusMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<RolesMenus> findByIds(List<String> ids) {
        RolesMenusEntity rolesMenusEntity = new RolesMenusEntity();
        rolesMenusEntity.createCriteria().andMenuIdIn(ids);
        return rolesMenusMapper.selectByEntity(rolesMenusEntity);
    }

    @Override
    public String create(RolesMenusReq req) {
        RolesMenus rolesMenus = new RolesMenus();
        BeanUtils.copyProperties(req, rolesMenus);
        rolesMenusMapper.insertSelective(rolesMenus);
        return rolesMenus.getMenuId();
    }

    @Override
    public void deleteById(String id) {
        rolesMenusMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        RolesMenusEntity rolesMenusEntity = new RolesMenusEntity();
        rolesMenusEntity.createCriteria().andMenuIdIn(ids);
        rolesMenusMapper.deleteByEntity(rolesMenusEntity);
    }

    @Override
    public void updateById(RolesMenusReq req) {
        RolesMenus rolesMenus = new RolesMenus();
        BeanUtils.copyProperties(req, rolesMenus);
        int result = rolesMenusMapper.updateByPrimaryKeySelective(rolesMenus);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}