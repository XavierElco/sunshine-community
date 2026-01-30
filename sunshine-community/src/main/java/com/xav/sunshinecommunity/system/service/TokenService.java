package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.LoginUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Li,chengming
 * @date 2026/1/29 18:31
 */
@Service
public interface TokenService {


    /**
     * 创建令牌
     * @param loginUser
     * @return
     */
    String createToken(LoginUser loginUser);


    /**
     * 缓存用户信息，刷新令牌的有效期
     * @param loginUser
     */
    void refreshToken(LoginUser loginUser);

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    LoginUser getLoginUser(HttpServletRequest request);


    /**
     * 验证令牌的有效期，并且要实现自动刷新缓存
     * @param loginUser
     */
    public void  verifyToken(LoginUser loginUser);


    /**
     * 设置用户身份信息
     * @param loginUser
     */
    public void setLoginUser(LoginUser loginUser);


    /**
     * 删除用户
     * @param token
     */
    public void delLoginUser(String token);
}
