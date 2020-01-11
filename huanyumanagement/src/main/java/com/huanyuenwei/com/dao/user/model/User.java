package com.huanyumanagement.dao.user.model;

import java.math.BigDecimal;

/**
 * @author 懒猴子CG
 * @date 2019-12-26 15:59:50
 * @email http://cg.lazy-monkey.com
 */
public class User {

    // ID
    private String userId;
    
    // 头像地址
    private String avatar;
    
    // 创建日期
    private String createTime;
    
    // 邮箱
    private String email;
    
    // 状态：1启用、0禁用
    private Character enabled;
    
    // 密码
    private String password;
    
    // 用户名
    private String username;
    
    // 最后修改密码的日期
    private String lastPasswordResetTime;
    
    // 部门id
    private Long deptId;
    
    // 手机号
    private String phone;
    
    // 职位id
    private Long jobId;
    
    // 小程序唯一标识
    private String openid;
    
    // 微信名称
    private String wx_name;
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar){
        this.avatar = avatar;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public Character getEnabled() {
        return enabled;
    }

    public void setEnabled(Character enabled){
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getLastPasswordResetTime() {
        return lastPasswordResetTime;
    }

    public void setLastPasswordResetTime(String lastPasswordResetTime){
        this.lastPasswordResetTime = lastPasswordResetTime;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId){
        this.deptId = deptId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId){
        this.jobId = jobId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid){
        this.openid = openid;
    }

    public String getWx_name() {
        return wx_name;
    }

    public void setWx_name(String wx_name){
        this.wx_name = wx_name;
    }

}