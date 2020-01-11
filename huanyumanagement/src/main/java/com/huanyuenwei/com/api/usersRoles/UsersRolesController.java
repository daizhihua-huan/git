package com.huanyuenwei.com.api.usersRoles;

import com.huanyuenwei.com.api.BaseController;
import com.huanyuenwei.com.core.model.R;
import com.huanyumanagement.dao.usersRoles.model.UsersRoles;
import com.huanyuenwei.com.dao.usersRoles.req.UsersRolesReq;
import com.huanyuenwei.com.service.usersRoles.UsersRolesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.math.BigDecimal;

/**
 * 用户角色表
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@RestController
@RequestMapping("/usersRoles")
public class UsersRolesController extends BaseController {

    @Autowired
    private UsersRolesService usersRolesService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/{id}")
    public R<UsersRoles> findById(@PathVariable Long id) {
        return R.data(usersRolesService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/batch/{ids}")
    public R<List<UsersRoles>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<Long> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(Long.valueOf(id.trim()));
            }
            return R.data(usersRolesService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/create")
    public R create(UsersRolesReq req) {
        return R.data(usersRolesService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable Long id) {
        usersRolesService.deleteById(id);
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
            List<Long> idList = new ArrayList<>();
            for (String id: idArray) {
              idList.add(Long.valueOf(id.trim()));
            }
            usersRolesService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/update")
    public R updateById(UsersRolesReq req) {
        usersRolesService.updateById(req);
        return R.success();
    }

}