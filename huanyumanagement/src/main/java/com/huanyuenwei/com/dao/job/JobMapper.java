package com.huanyuenwei.com.dao.job;

import com.huanyumanagement.dao.job.model.Job;
import com.huanyuenwei.com.dao.job.model.JobEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JobMapper {
    int countByEntity(JobEntity entity);

    int deleteByEntity(JobEntity entity);

    int deleteByPrimaryKey(String id);

    int insert(Job record);

    int insertSelective(Job record);

    List<Job> selectByEntity(JobEntity entity);

    Job selectByPrimaryKey(String id);

    int updateByEntitySelective(@Param("record") Job record, @Param("entity") JobEntity entity);

    int updateByEntity(@Param("record") Job record, @Param("entity") JobEntity entity);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);
}