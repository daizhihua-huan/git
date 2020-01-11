package com.huanyumanagement.dao.rolesPermissions.model;


/**
 * @author 懒猴子CG
 * @date 2019-12-26 15:59:50
 * @email http://cg.lazy-monkey.com
 */
public class RolesPermissions {

    // 角色ID
    private String roleId;
    
    // 权限ID
    private String permissionId;
    
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId){
        this.permissionId = permissionId;
    }

}