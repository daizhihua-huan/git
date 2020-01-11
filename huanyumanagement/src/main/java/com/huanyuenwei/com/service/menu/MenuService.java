package com.huanyuenwei.com.service.menu;

import com.huanyumanagement.dao.menu.model.Menu;
import com.huanyuenwei.com.dao.menu.req.MenuReq;

import java.util.List;

/**
 * menu业务接口定义
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public interface MenuService {

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    Menu findById(String id);

    /**
     * 根据ID集查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    List<Menu> findByIds(List<String> ids);

    /**
     * 创建
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    String create(MenuReq req);

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
    void updateById(MenuReq req);

}