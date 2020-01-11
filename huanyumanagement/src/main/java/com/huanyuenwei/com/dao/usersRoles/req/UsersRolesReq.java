package com.huanyuenwei.com.dao.usersRoles.req;

import java.math.BigDecimal;

/**
 * usersRoles通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class UsersRolesReq {

    // 用户ID
    private Long userId;

    // 角色ID
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId){
        this.roleId = roleId;
    }

}