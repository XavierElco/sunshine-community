package com.xav.sunshinecommunity.system.service;

import com.xav.sunshinecommunity.system.domain.LoginUser;
import org.springframework.stereotype.Service;

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


}
