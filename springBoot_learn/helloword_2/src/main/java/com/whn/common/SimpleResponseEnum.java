package com.whn.common;

import lombok.Getter;

/**
 * @Author: WangHn
 * @Date: 2024/1/12 14:18
 * @Description: 响应编码枚举
 */
@Getter
public enum SimpleResponseEnum {
    // 成功响应
    SUCCESS(200, "操作成功"),
    // 失败响应
    FAILURE(500, "服务器内部错误"),
    // 未授权
    UNAUTHORIZED(401, "未授权，请登录"),
    // 请求资源不存在
    NOT_FOUND(404, "请求的资源不存在"),
    // 默认
    DEFAULT_ERROR(107,"默认编码"),
    // 参数错误
    BAD_REQUEST(400, "参数错误");


    /**
     * 状态码
     */
    private final int code;
    /**
     * 描述信息
     */
    private final String message;

    SimpleResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 可以根据状态码获取枚举实例
    public static SimpleResponseEnum getByCode(int code) {
        for (SimpleResponseEnum status : values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        // 如果没有找到匹配的状态码，可以返回默认的或者抛出异常
        return DEFAULT_ERROR; // 假设有一个DEFAULT_ERROR枚举项
    }
}
