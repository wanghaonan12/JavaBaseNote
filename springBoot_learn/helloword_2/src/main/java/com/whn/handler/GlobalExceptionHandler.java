package com.whn.handler;


import com.whn.common.SimpleResponse;
import com.whn.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 17:32
 * @Description: 统一异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义的业务异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = CustomException.class)
    @ResponseBody
    public SimpleResponse bizExceptionHandler(HttpServletRequest req, CustomException e){
        log.error("发生业务异常！原因是：{}",e);
        return SimpleResponse.failure("发生业务异常");
    }

    /**
     * 处理空指针的异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public SimpleResponse exceptionHandler(HttpServletRequest req, NullPointerException e){
        log.error("发生空指针异常！原因是:",e);
        return SimpleResponse.failure("发生空指针异常");
    }

    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public SimpleResponse exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:",e);
        return SimpleResponse.failure("未知异常");
    }
}

