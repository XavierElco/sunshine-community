package com.xav.sunshinecommunity.common.core.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletResponse;

/**
 * 业务异常基类
 * @author Li,chengming
 * @date 2026/1/29 19:07
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomException extends RuntimeException {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回的消息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     */
    private boolean success;

    public CustomException(int code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public CustomException(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.success = HttpServletResponse.SC_OK == code;
    }

    public CustomException(String msg) {
        this.msg = msg;
    }


}
