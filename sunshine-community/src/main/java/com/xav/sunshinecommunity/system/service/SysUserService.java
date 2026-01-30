package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.SysUser;

/**
 * @author Li,chengming
 * @date 2026/1/29 17:20
 */
public interface SysUserService {

    SysUser selectUserByUsername(String username);
}
