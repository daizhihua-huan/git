package com.huanyuenwei.com.api.job;

import com.huanyuenwei.com.api.BaseController;
import com.huanyuenwei.com.core.model.R;
import com.huanyumanagement.dao.job.model.Job;
import com.huanyuenwei.com.dao.job.req.JobReq;
import com.huanyuenwei.com.service.job.JobService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 职位
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@RestController
@RequestMapping("/job")
public class JobController extends BaseController {

    @Autowired
    private JobService jobService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/{id}")
    public R<Job> findById(@PathVariable String id) {
        return R.data(jobService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/batch/{ids}")
    public R<List<Job>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(id.trim());
            }
            return R.data(jobService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/create")
    public R create(JobReq req) {
        return R.data(jobService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable String id) {
        jobService.deleteById(id);
        return R.success();
    }

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/batch/{ids}")
    public R deleteByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
              idList.add(id.trim());
            }
            jobService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/update")
    public R updateById(JobReq req) {
        jobService.updateById(req);
        return R.success();
    }

}