package com.whn.common;

import lombok.Data;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 14:14
 * @Description: 请求响应类
 */
@Data
public class SimpleResponse {
    /**
     * 消息描述
     */
    private String message;
    /**
     * 响应编码
     */
    private int code;
    /**
     * 响应数据
     */
    private  Object data;

    public  SimpleResponse(Object data, SimpleResponseEnum simpleResponseEnum) {
        this.message = simpleResponseEnum.getMessage();
        this.code = simpleResponseEnum.getCode();
        this.data = data;
    }

    public static  SimpleResponse success(Object data){
        return new SimpleResponse(data, SimpleResponseEnum.SUCCESS);
    }

    public static  SimpleResponse error(Object data){
        return new SimpleResponse(data, SimpleResponseEnum.BAD_REQUEST);
    }

    public static  SimpleResponse failure(Object data){
        return new SimpleResponse(data, SimpleResponseEnum.FAILURE);
    }

}
