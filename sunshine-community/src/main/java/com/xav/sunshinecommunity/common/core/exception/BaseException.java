package com.xav.sunshinecommunity.common.core.exception;

/**
 * @author Li,chengming
 * @date 2026/1/9 21:26
 */
public class BaseException extends RuntimeException{
    private static final long serialVersionUID = -2095302274518592258L;
    // 错误码
    private String code;

    // 错误的消息
    private String defaultMessage;

    public BaseException(String code, String defaultMessage) {
        this.defaultMessage = defaultMessage;
        this.code = code;

    }

    public BaseException() {
    }

    public BaseException(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
