package com.huanyumanagement.dao.permission.model;


/**
 * @author 懒猴子CG
 * @date 2019-12-26 15:59:50
 * @email http://cg.lazy-monkey.com
 */
public class Permission {

    // ID
    private String permissionId;
    
    // 别名
    private String alias;
    
    // 创建日期
    private String createTime;
    
    // 名称
    private String name;
    
    // 上级权限
    private String pid;
    
    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId){
        this.permissionId = permissionId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias){
        this.alias = alias;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid){
        this.pid = pid;
    }

}