package com.huanyuenwei.com.api.rolesMenus;

import com.huanyuenwei.com.api.BaseController;
import com.huanyuenwei.com.core.model.R;
import com.huanyumanagement.dao.rolesMenus.model.RolesMenus;
import com.huanyuenwei.com.dao.rolesMenus.req.RolesMenusReq;
import com.huanyuenwei.com.service.rolesMenus.RolesMenusService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 角色菜单表
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
@RestController
@RequestMapping("/rolesMenus")
public class RolesMenusController extends BaseController {

    @Autowired
    private RolesMenusService rolesMenusService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/{id}")
    public R<RolesMenus> findById(@PathVariable String id) {
        return R.data(rolesMenusService.findById(id));
    }

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/batch/{ids}")
    public R<List<RolesMenus>> findByIds(@PathVariable String ids) {
        if(StringUtils.isNotBlank(ids)) {
            String[] idArray = ids.split(",");
            List<String> idList = new ArrayList<>();
            for (String id: idArray) {
                idList.add(id.trim());
            }
            return R.data(rolesMenusService.findByIds(idList));
        }
        return R.success();
    }
    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/create")
    public R create(RolesMenusReq req) {
        return R.data(rolesMenusService.create(req));
    }

    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @GetMapping("/delete/{id}")
    public R deleteById(@PathVariable String id) {
        rolesMenusService.deleteById(id);
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
            rolesMenusService.deleteByIds(idList);
        }
        return R.success();
    }
    /**
     * 根据ID更新
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @PostMapping("/update")
    public R updateById(RolesMenusReq req) {
        rolesMenusService.updateById(req);
        return R.success();
    }

}