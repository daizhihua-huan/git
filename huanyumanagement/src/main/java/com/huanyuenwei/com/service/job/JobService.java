package com.huanyuenwei.com.service.job;

import com.huanyumanagement.dao.job.model.Job;
import com.huanyuenwei.com.dao.job.req.JobReq;

import java.util.List;

/**
 * job业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface JobService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    Job findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<Job> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(JobReq req);

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteById(String id);

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void deleteByIds(List<String> ids);

    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    void updateById(JobReq req);

}