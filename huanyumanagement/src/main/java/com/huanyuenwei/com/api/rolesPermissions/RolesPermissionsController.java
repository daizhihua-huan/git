package com.huanyuenwei.com.api.rolesPermissions;

import com.huanyuenwei.com.api.BaseController;
import com.huanyuenwei.com.core.model.R;
import com.huanyumanagement.dao.rolesPermissions.model.RolesPermissions;
import com.huanyuenwei.com.dao.rolesPermissions.req.RolesPermissionsReq;
import com.huanyuenwei.com.service.rolesPermissions.RolesPermissionsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 角色权限表
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@RestController
@RequestMapping("/rolesPermissions")
public class RolesPermissionsController extends BaseController {

    @Autowired
    private RolesPermissionsService rolesPermissionsService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/{id}")
    public R<RolesPermissions> findById(@PathVariable String id) {
        return R.data(rolesPermissionsService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/batch/{ids}")
    public R<List<RolesPermissions>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(id.trim());
            }
            return R.data(rolesPermissionsService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/create")
    public R create(RolesPermissionsReq req) {
        return R.data(rolesPermissionsService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable String id) {
        rolesPermissionsService.deleteById(id);
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
            rolesPermissionsService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/update")
    public R updateById(RolesPermissionsReq req) {
        rolesPermissionsService.updateById(req);
        return R.success();
    }

}