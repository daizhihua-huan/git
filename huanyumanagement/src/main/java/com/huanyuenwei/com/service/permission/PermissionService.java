package com.huanyuenwei.com.service.permission;

import com.huanyumanagement.dao.permission.model.Permission;
import com.huanyuenwei.com.dao.permission.req.PermissionReq;

import java.util.List;

/**
 * permission业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface PermissionService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    Permission findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<Permission> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(PermissionReq req);

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
    void updateById(PermissionReq req);

}