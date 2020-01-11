package com.huanyuenwei.com.dao.job.req;


/**
 * job通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class JobReq {

    private String jobId;

    // 名称
    private String name;

    private String enabled;

    private String createTime;

    private String sort;

    // 部门id
    private String deptId;

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId){
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled){
        this.enabled = enabled;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort){
        this.sort = sort;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId){
        this.deptId = deptId;
    }

}