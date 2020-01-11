package com.huanyuenwei.com.service.user;

import com.huanyumanagement.dao.user.model.User;
import com.huanyuenwei.com.dao.user.req.UserReq;

import java.util.List;
import java.math.BigDecimal;

/**
 * user业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface UserService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    User findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<User> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(UserReq req);

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
    void updateById(UserReq req);

}