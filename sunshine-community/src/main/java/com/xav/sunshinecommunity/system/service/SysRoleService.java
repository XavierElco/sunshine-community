package com.xav.sunshinecommunity.system.service;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 业务层
 * @author Li,chengming
 * @date 2026/1/30 18:28
 */
@Service
public interface SysRoleService {

    /**
     * 根据用户ID查询角色信息
     * @param userId
     * @return
     */
    public Set<String> selectRolePermissionByUserId(Long userId);
}
