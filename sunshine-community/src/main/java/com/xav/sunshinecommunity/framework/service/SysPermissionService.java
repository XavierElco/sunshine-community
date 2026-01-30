package com.xav.sunshinecommunity.framework.service;

import com.xav.sunshinecommunity.common.utils.ChainedMap;
import com.xav.sunshinecommunity.system.domain.SysUser;
import com.xav.sunshinecommunity.system.service.SysRoleService;
import com.xav.sunshinecommunity.system.service.impl.SysMenuService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户权限处理
 * @author Li,chengming
 * @date 2026/1/30 21:09
 */
@Component
public class SysPermissionService {

    @Resource
    private SysMenuService sysMenuService;

    @Resource
    private SysRoleService sysRoleService;


    /**
     * 获取角色数据权限
     * @param user
     * @return
     */
    public Set<String> getRolePermission(SysUser user) {
        Set<String> roles = new HashSet<>();

        if (user.isAdmin()) {
            roles.add("admin");
        } else {
            roles = sysRoleService.selectRolePermissionByUserId(user.getUserId());
        }
        return roles;
    }


    /**
     * 获取菜单数据权限
     * @param user
     * @return
     */
    public Set<String> getMenuPermission(SysUser user) {
        Set<String> perms = new HashSet<>();

        // 是管理员就拥有所有权限
        if (user.isAdmin()) {
            perms.add("*:*:*");
        } else {
            perms = sysMenuService.selectMenuPermsByUserId(user.getUserId());
        }
        return perms;
    }


}
