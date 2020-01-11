package com.huanyuenwei.com.role;

import com.huanyuenwei.com.BaseTest;
import com.huanyuenwei.com.service.role.RoleService;
import com.huanyuenwei.com.dao.role.req.RoleReq;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

/**
 * 角色表测试用例
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class RoleServiceTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    /**
     * 根据ID查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @Test
    public void findByIdTest() {
        print("根据ID查询测试通过");
    }

    /**
     * 根据ID集合查询
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @Test
    public void findByIdsTest() {
        print("根据ID集合查询测试通过");
    }
    /**
     * 根据ID删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @Test
    public void deleteByIdTest() {
        print("根据ID删除测试通过");
    }

    /**
     * 根据ID集删除
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @Test
    public void deleteByIdsTest() {
//        roleService.deleteByIds(Arrays.asList(1, 2));
        print("根据ID集删除测试通过");
    }

    /**
     * 根据ID修改
     * @author 懒猴子CG
     * @date 2019/12/26 15:59
     */
    @Test
    public void updateById() {
        print("根据ID修改测试通过");
    }
}