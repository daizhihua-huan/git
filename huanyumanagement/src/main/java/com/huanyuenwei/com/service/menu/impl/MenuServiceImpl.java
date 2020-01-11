package com.huanyuenwei.com.service.menu.impl;

import com.huanyuenwei.com.dao.menu.MenuMapper;
import com.huanyumanagement.dao.menu.model.Menu;
import com.huanyuenwei.com.dao.menu.model.MenuEntity;
import com.huanyuenwei.com.dao.menu.req.MenuReq;
import com.huanyuenwei.com.service.menu.MenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 菜单表业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Menu findById(String id) {
        return menuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Menu> findByIds(List<String> ids) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.createCriteria().andMenuIdIn(ids);
        return menuMapper.selectByEntity(menuEntity);
    }

    @Override
    public String create(MenuReq req) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(req, menu);
        menuMapper.insertSelective(menu);
        return menu.getMenuId();
    }

    @Override
    public void deleteById(String id) {
        menuMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.createCriteria().andMenuIdIn(ids);
        menuMapper.deleteByEntity(menuEntity);
    }

    @Override
    public void updateById(MenuReq req) {
        Menu menu = new Menu();
        BeanUtils.copyProperties(req, menu);
        int result = menuMapper.updateByPrimaryKeySelective(menu);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}