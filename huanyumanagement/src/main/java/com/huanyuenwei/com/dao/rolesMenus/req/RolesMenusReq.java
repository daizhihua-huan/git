package com.huanyuenwei.com.dao.rolesMenus.req;


/**
 * rolesMenus通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class RolesMenusReq {

    // 菜单ID
    private String menuId;

    // 角色ID
    private String roleId;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId){
        this.menuId = menuId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

}