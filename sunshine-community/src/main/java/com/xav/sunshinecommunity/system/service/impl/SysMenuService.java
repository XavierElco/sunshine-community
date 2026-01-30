package com.xav.sunshinecommunity.system.service.impl;

import java.util.Set;

/**
 * @author Li,chengming
 * @date 2026/1/30 20:27
 */
public interface SysMenuService {

    /**
     * 根据用户ID查询菜单信息
     * @param userId
     * @return
     */
    public Set<String> selectMenuPermsByUserId(Long userId);
}
