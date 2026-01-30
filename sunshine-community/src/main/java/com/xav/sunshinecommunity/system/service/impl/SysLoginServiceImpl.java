package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.common.constant.Constants;
import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.common.core.exception.UserPasswordNotMatchException;
import com.xav.sunshinecommunity.common.utils.RedisCache;
import com.xav.sunshinecommunity.common.core.exception.CaptchaNotMatch;
import com.xav.sunshinecommunity.system.domain.LoginUser;
import com.xav.sunshinecommunity.system.service.SysLoginService;
import com.xav.sunshinecommunity.system.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Li,chengming
 * @date 2026/1/29 18:20
 */
@Service
public class SysLoginServiceImpl implements SysLoginService {
    
    @Resource
    private RedisCache redisCache;

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private TokenService tokenService;

    /**
     * 带验证码登录
     */
    @Override
    public String login(String username, String password, String code, String uuid) {

        // 1. 从redis中获取验证码判断是不是正确的
        String key = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisCache.getCacheObject(key);
        redisCache.deleteObject(key);

        if (Objects.isNull(captcha) || !captcha.equalsIgnoreCase(code)) {
            throw new CaptchaNotMatch("验证码错误");
        }

        // 2. 没有问题就进行用户的认证
        Authentication authentication = null;
        try {
            authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new UserPasswordNotMatchException();
        }

        // 3. 获取用户经过身份验证后的主体信息
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        String token = tokenService.createToken(loginUser);

        return token;

    }
}
