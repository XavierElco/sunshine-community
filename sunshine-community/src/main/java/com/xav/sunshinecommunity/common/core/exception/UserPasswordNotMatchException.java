package com.xav.sunshinecommunity.common.core.exception;

/**
 * 用户密码不正确异常类
 * @author Li,chengming
 * @date 2026/1/30 15:39
 */
public class UserPasswordNotMatchException extends CustomException{

    public UserPasswordNotMatchException() {
        super(400, "用户不存在/密码错误");
    }
}
