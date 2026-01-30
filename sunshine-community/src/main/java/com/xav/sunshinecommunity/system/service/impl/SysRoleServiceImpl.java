package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.system.mapper.SysRoleMapper;
import com.xav.sunshinecommunity.system.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Li,chengming
 * @date 2026/1/30 18:29
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    SysRoleMapper sysRoleMapper;

    @Override
    public Set<String> selectRolePermissionByUserId(Long userId) {

        List<String> list = sysRoleMapper.selectRolePermissionByUserId(userId);
        HashSet<String> permSet = new HashSet<>();
        for (String roleKey : list) {
            if (Objects.nonNull(roleKey) && !Objects.equals(roleKey, "")) {
                permSet.add(roleKey);
            }
        }

        return permSet;
    }
}
