package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.common.constant.Constants;
import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.common.utils.RedisCache;
import com.xav.sunshinecommunity.system.domain.LoginUser;
import com.xav.sunshinecommunity.system.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Li,chengming
 * @date 2026/1/29 18:33
 */
@Component
public class TokenServiceImpl implements TokenService {

    @Resource
    RedisCache redisCache;

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;

    // 毫秒
    private static final long MILLIS_SECOND = 1000;

    // 分钟
    private static final long MILLIS_MINUTE = MILLIS_SECOND * 60;

    // 20分钟
    private static final long MILLIS_MINUTE_TEN = MILLIS_SECOND * 60 * 20;


    /**
     * 创建令牌
     * @param loginUser
     * @return
     */
    @Override
    public String createToken(LoginUser loginUser) {

        // 设置用户的唯一标识
        String userKey = UUID.randomUUID().toString();
        loginUser.setToken(userKey);

        //todo 保存用户信息 刷新令牌
        refreshToken(loginUser);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, userKey);

        String jwt =  Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secret).compact();

        if (jwt == null) {
            throw new BaseException("令牌生成错误");
        }
        return jwt;
    }

    @Override
    public void refreshToken(LoginUser loginUser) {
        loginUser.setLoginTime(System.currentTimeMillis());

        // 过期时间30分钟
        loginUser.setExpireTime(System.currentTimeMillis() + expireTime * MILLIS_MINUTE);

        // 根据UUID将LoginUser缓存
        String userKey = getTokenKey(loginUser.getToken());
        redisCache.setCacheObject(userKey, loginUser, expireTime, TimeUnit.MINUTES);
    }

    // 拼接tokenKey
    private String getTokenKey(String userKey) {
        return Constants.LOGIN_TOKEN_KEY + userKey;
    }

    /**
     * 获取请求头中的token
     * @param request
     * @return
     */
    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(this.header);

        // JWT标准写法 Authorization：Bearer aaa.bb.cc
        if (!Objects.isNull(token) && token.startsWith(Constants.TOKEN_PREFIX)) {
            token = token.replace(Constants.TOKEN_PREFIX, "");
        }

        return token;
    }

    @Override
    public LoginUser getLoginUser(HttpServletRequest request) {
        String token = getToken(request);
        if (!Objects.isNull(token)) {
            Claims claims = parseToken(token);
            // 解析对应用户信息
            String uuid = (String)claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            LoginUser loginUser = redisCache.getCacheObject(userKey);
            return loginUser;
        }
        return null;
    }

    /**
     * 从令牌中获取数据
     * @param token
     * @return
     */
    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }


    /**
     * 验证令牌的有效期，并且要实现自动刷新缓存
     * @param loginUser
     */
    @Override
    public void  verifyToken(LoginUser loginUser) {
        Long expireTime = loginUser.getExpireTime();

        // 拿到当前时间
        long currentTimeMillis = System.currentTimeMillis();

        // 相差不足20分钟的话，自动刷新缓存
        if(expireTime - currentTimeMillis <= MILLIS_MINUTE_TEN) {
            refreshToken(loginUser);
        }
    }

    @Override
    public void setLoginUser(LoginUser loginUser) {
        if (!Objects.isNull(loginUser) && !StringUtils.isEmpty(loginUser.getToken())) {
            refreshToken(loginUser);
        }
    }


    @Override
    public void delLoginUser(String token) {
        if (!StringUtils.isEmpty(token)) {
            String userKey = getTokenKey(token);
            redisCache.deleteObject(userKey);
        }
    }
}
