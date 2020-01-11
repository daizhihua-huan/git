package com.huanyuenwei.com.service.job.impl;

import com.huanyuenwei.com.dao.job.JobMapper;
import com.huanyumanagement.dao.job.model.Job;
import com.huanyuenwei.com.dao.job.model.JobEntity;
import com.huanyuenwei.com.dao.job.req.JobReq;
import com.huanyuenwei.com.service.job.JobService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;


/**
 * 职位业务实现
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobMapper jobMapper;

    @Override
    public Job findById(String id) {
        return jobMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Job> findByIds(List<String> ids) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.createCriteria().andJobIdIn(ids);
        return jobMapper.selectByEntity(jobEntity);
    }

    @Override
    public String create(JobReq req) {
        Job job = new Job();
        BeanUtils.copyProperties(req, job);
        jobMapper.insertSelective(job);
        return job.getJobId();
    }

    @Override
    public void deleteById(String id) {
        jobMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if(CollectionUtils.isEmpty(ids))
            return;
        JobEntity jobEntity = new JobEntity();
        jobEntity.createCriteria().andJobIdIn(ids);
        jobMapper.deleteByEntity(jobEntity);
    }

    @Override
    public void updateById(JobReq req) {
        Job job = new Job();
        BeanUtils.copyProperties(req, job);
        int result = jobMapper.updateByPrimaryKeySelective(job);
        if(result == 0)
            throw new RuntimeException("更新失败，更新结果数为0");
    }
}