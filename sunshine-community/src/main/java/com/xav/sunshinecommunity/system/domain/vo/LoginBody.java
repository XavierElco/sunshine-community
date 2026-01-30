package com.xav.sunshinecommunity.system.domain.vo;

import lombok.Data;

/**
 * 用户登录表单对象
 * @author Li,chengming
 * @date 2026/1/29 18:17
 */
@Data
public class LoginBody {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 唯一标识
     */
    private String uuid="";
}
