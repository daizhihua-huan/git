package com.huanyumanagement.dao.role.model;


/**
 * @author 懒猴子CG
 * @date 2019-12-26 15:59:50
 * @email http://cg.lazy-monkey.com
 */
public class Role {

    // ID
    private String roleId;
    
    // 创建日期
    private String createTime;
    
    // 名称
    private String name;
    
    // 备注
    private String remark;
    
    private String dataScope;
    
    // 级别
    private String level;
    
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId){
        this.roleId = roleId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark){
        this.remark = remark;
    }

    public String getDataScope() {
        return dataScope;
    }

    public void setDataScope(String dataScope){
        this.dataScope = dataScope;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level){
        this.level = level;
    }

}