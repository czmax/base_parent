package com.max.code.base.common.entity;

import lombok.Data;

/**
 * 统一json返回格式
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
}
