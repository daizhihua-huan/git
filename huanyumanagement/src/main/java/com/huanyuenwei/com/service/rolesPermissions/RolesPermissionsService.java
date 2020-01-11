package com.huanyuenwei.com.service.rolesPermissions;

import com.huanyumanagement.dao.rolesPermissions.model.RolesPermissions;
import com.huanyuenwei.com.dao.rolesPermissions.req.RolesPermissionsReq;

import java.util.List;

/**
 * rolesPermissions业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface RolesPermissionsService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    RolesPermissions findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<RolesPermissions> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(RolesPermissionsReq req);

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
    void updateById(RolesPermissionsReq req);

}