package com.huanyuenwei.com.dao.rolesPermissions.req;


/**
 * rolesPermissions通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class RolesPermissionsReq {

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