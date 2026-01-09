package com.xav.sunshinecommunity.common.core.exception;

import com.xav.sunshinecommunity.common.core.domain.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Li,chengming
 * @date 2026/1/9 21:36
 */

@RestControllerAdvice //在controller层做了一个切面
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse baseExceptionHandler(BaseException e){
        return BaseResponse.fail(e.getDefaultMessage());
    }

}
