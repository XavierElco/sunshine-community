package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.common.enums.UserStatus;
import com.xav.sunshinecommunity.system.domain.LoginUser;
import com.xav.sunshinecommunity.system.domain.SysUser;
import com.xav.sunshinecommunity.system.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Li,chengming
 * @date 2026/1/29 17:35
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser user = sysUserService.selectUserByUsername(username);

        if (Objects.isNull(user)) {
            log.info("登陆用户: {} 不存在", username);
            throw new UsernameNotFoundException("登陆用户" + username + "不存在");
        } else if (UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            log.info("登陆用户: {} 已被删除", username);
            throw new BaseException("对不起，您的账号" + username + "已被删除");
        } else if (UserStatus.DISABLE.getCode().equals(user.getDelFlag())) {
            log.info("登陆用户: {} 已被停用", username);
            throw new BaseException("对不起，您的账号" + username + "已被停用");
        }

        return new LoginUser(user);
    }
}
