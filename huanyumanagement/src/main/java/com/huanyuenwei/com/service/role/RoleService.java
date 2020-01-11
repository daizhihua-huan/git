package com.huanyuenwei.com.service.role;

import com.huanyumanagement.dao.role.model.Role;
import com.huanyuenwei.com.dao.role.req.RoleReq;

import java.util.List;

/**
 * role业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface RoleService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    Role findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<Role> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(RoleReq req);

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
    void updateById(RoleReq req);

}