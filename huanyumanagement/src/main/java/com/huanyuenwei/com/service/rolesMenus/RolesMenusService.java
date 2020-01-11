package com.huanyuenwei.com.service.rolesMenus;

import com.huanyumanagement.dao.rolesMenus.model.RolesMenus;
import com.huanyuenwei.com.dao.rolesMenus.req.RolesMenusReq;

import java.util.List;

/**
 * rolesMenus业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface RolesMenusService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    RolesMenus findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<RolesMenus> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(RolesMenusReq req);

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteById(String id);

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteByIds(List<String> ids);

    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void updateById(RolesMenusReq req);

}