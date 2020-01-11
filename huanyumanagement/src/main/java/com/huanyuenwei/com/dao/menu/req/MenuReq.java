package com.huanyuenwei.com.dao.menu.req;


/**
 * menu通用请求参数
 * @author 懒猴子CG
 * @date 2019/12/26 15:59
 */
public class MenuReq {

    // ID
    private String menuId;

    // 创建日期
    private String createTime;

    // 是否外链
    private String iFrame;

    // 菜单名称
    private String name;

    // 组件
    private String component;

    // 上级菜单ID
    private String pid;

    // 排序
    private String sort;

    // 图标
    private String icon;

    // 链接地址
    private String path;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId){
        this.menuId = menuId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime){
        this.createTime = createTime;
    }

    public String getIFrame() {
        return iFrame;
    }

    public void setIFrame(String iFrame){
        this.iFrame = iFrame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component){
        this.component = component;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid){
        this.pid = pid;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort){
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon){
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path){
        this.path = path;
    }

}