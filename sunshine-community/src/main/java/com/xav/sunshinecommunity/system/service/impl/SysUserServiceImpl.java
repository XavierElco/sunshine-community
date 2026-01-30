package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.system.domain.SysUser;
import com.xav.sunshinecommunity.system.mapper.SysUserMapper;
import com.xav.sunshinecommunity.system.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Li,chengming
 * @date 2026/1/29 17:20
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectUserByUsername(String username) {
        return sysUserMapper.selectUserByUserName(username);
    }
}
