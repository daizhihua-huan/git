package com.huanyuenwei.com.service.usersRoles;

import com.huanyumanagement.dao.usersRoles.model.UsersRoles;
import com.huanyuenwei.com.dao.usersRoles.req.UsersRolesReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * usersRoles业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface UsersRolesService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    UsersRoles findById(Long id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<UsersRoles> findByIds(List<Long> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    Long create(UsersRolesReq req);

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteById(Long id);

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteByIds(List<Long> ids);

    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void updateById(UsersRolesReq req);

}