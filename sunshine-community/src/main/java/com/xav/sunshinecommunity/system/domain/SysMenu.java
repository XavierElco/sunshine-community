package com.xav.sunshinecommunity.system.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.xav.sunshinecommunity.common.core.domain.BaseEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Li,chengming
 * @date 2026/1/30 18:14
 */
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = 1L;
    @TableId
    private Long menuId;
    private String menuName;
    private String parentName;
    private Long parentId;
    private String orderNum;
    private String path;
    private String component;
    private String isFrame;
    private String isCache;
    private String menuType;
    private String visible;
    private String status;
    private String perms;
    private String icon;
    private List<SysMenu> children = new ArrayList();

    public Long getMenuId() {
        return this.menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public @NotBlank(
            message = "菜单名称不能为空"
    ) @Size(
            min = 0,
            max = 50,
            message = "菜单名称长度不能超过50个字符"
    ) String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getParentName() {
        return this.parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public @NotBlank(
            message = "显示顺序不能为空"
    ) String getOrderNum() {
        return this.orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public @Size(
            min = 0,
            max = 200,
            message = "路由地址不能超过200个字符"
    ) String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public @Size(
            min = 0,
            max = 200,
            message = "组件路径不能超过255个字符"
    ) String getComponent() {
        return this.component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIsFrame() {
        return this.isFrame;
    }

    public void setIsFrame(String isFrame) {
        this.isFrame = isFrame;
    }

    public String getIsCache() {
        return this.isCache;
    }

    public void setIsCache(String isCache) {
        this.isCache = isCache;
    }

    public @NotBlank(
            message = "菜单类型不能为空"
    ) String getMenuType() {
        return this.menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getVisible() {
        return this.visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public @Size(
            min = 0,
            max = 100,
            message = "权限标识长度不能超过100个字符"
    ) String getPerms() {
        return this.perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<SysMenu> getChildren() {
        return this.children;
    }

    public void setChildren(List<SysMenu> children) {
        this.children = children;
    }

    public String toString() {
        return "SysMenu{menuId=" + this.menuId + ", menuName='" + this.menuName + '\'' + ", parentName='" + this.parentName + '\'' + ", parentId=" + this.parentId + ", orderNum='" + this.orderNum + '\'' + ", path='" + this.path + '\'' + ", component='" + this.component + '\'' + ", isFrame='" + this.isFrame + '\'' + ", isCache='" + this.isCache + '\'' + ", menuType='" + this.menuType + '\'' + ", visible='" + this.visible + '\'' + ", status='" + this.status + '\'' + ", perms='" + this.perms + '\'' + ", icon='" + this.icon + '\'' + ", children=" + this.children + '}';
    }
}
