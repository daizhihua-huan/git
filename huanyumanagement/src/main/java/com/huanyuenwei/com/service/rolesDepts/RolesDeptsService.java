package com.huanyuenwei.com.service.rolesDepts;

import com.huanyumanagement.dao.rolesDepts.model.RolesDepts;
import com.huanyuenwei.com.dao.rolesDepts.req.RolesDeptsReq;

import java.util.List;

/**
 * rolesDepts业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface RolesDeptsService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    RolesDepts findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<RolesDepts> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(RolesDeptsReq req);

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
    void updateById(RolesDeptsReq req);

}