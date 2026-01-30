package com.xav.sunshinecommunity.common.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 自定义验证码异常
 * @author Li,chengming
 * @date 2026/1/28 20:38
 */
public class CaptchaNotMatch extends CustomException{

    public CaptchaNotMatch() {
        super(400, "验证码错误");
    }

    public CaptchaNotMatch(String msg) {
        super(msg);
    }


}
