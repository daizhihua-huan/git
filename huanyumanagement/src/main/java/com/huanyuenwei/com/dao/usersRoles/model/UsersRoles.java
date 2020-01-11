package com.huanyumanagement.dao.usersRoles.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2019-12-26 15:59:50
 * @email http://cg.lazy-monkey.com
 */
public class UsersRoles {

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