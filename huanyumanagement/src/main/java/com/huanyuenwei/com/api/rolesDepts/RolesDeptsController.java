package com.huanyuenwei.com.api.rolesDepts;

import com.huanyuenwei.com.api.BaseController;
import com.huanyuenwei.com.core.model.R;
import com.huanyumanagement.dao.rolesDepts.model.RolesDepts;
import com.huanyuenwei.com.dao.rolesDepts.req.RolesDeptsReq;
import com.huanyuenwei.com.service.rolesDepts.RolesDeptsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 角色部门表
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@RestController
@RequestMapping("/rolesDepts")
public class RolesDeptsController extends BaseController {

    @Autowired
    private RolesDeptsService rolesDeptsService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/{id}")
    public R<RolesDepts> findById(@PathVariable String id) {
        return R.data(rolesDeptsService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/batch/{ids}")
    public R<List<RolesDepts>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(id.trim());
            }
            return R.data(rolesDeptsService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/create")
    public R create(RolesDeptsReq req) {
        return R.data(rolesDeptsService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable String id) {
        rolesDeptsService.deleteById(id);
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
            rolesDeptsService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/update")
    public R updateById(RolesDeptsReq req) {
        rolesDeptsService.updateById(req);
        return R.success();
    }

}