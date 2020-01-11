package com.huanyuenwei.com.dao.rolesDepts.req;


/**
 * rolesDepts通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class RolesDeptsReq {

    private String roleId;

    private String deptId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId){
        this.deptId = deptId;
    }

}