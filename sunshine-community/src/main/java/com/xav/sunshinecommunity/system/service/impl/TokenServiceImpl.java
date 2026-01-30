package com.xav.sunshinecommunity.system.service.impl;

import com.xav.sunshinecommunity.common.constant.Constants;
import com.xav.sunshinecommunity.common.core.exception.BaseException;
import com.xav.sunshinecommunity.system.domain.LoginUser;
import com.xav.sunshinecommunity.system.service.TokenService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.UUID;

/**
 * @author Li,chengming
 * @date 2026/1/29 18:33
 */
@Component
public class TokenServiceImpl implements TokenService {

    // 令牌自定义标识
    @Value("${token.header}")
    private String header;

    // 令牌秘钥
    @Value("${token.secret}")
    private String secret;

    // 令牌有效期（默认30分钟）
    @Value("${token.expireTime}")
    private int expireTime;


    @Override
    public String createToken(LoginUser loginUser) {

        // 设置用户的唯一标识
        String userKey = UUID.randomUUID().toString();
        loginUser.setToken(userKey);

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
}
