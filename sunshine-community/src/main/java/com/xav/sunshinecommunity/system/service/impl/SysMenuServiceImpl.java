package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.system.mapper.SysMenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author Li,chengming
 * @date 2026/1/30 20:28
 */
@Service
public class SysMenuServiceImpl implements SysMenuService{

    @Resource
    SysMenuMapper sysMenuMapper;

    @Override
    public Set<String> selectMenuPermsByUserId(Long userId) {
        List<String> list = sysMenuMapper.selectMenuPermissionByUserId(userId);

        HashSet<String> set = new HashSet<>();

        for (String perms : list) {
            if (Objects.nonNull(perms) && !Objects.equals(perms, "")) {
                set.add(perms);
            }

        }
        return set;
    }
}
