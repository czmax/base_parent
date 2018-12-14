package com.max.code.sys.entity;

import lombok.Data;

/**
 * @author Chen
 * @created 2018-12-14-11:47.
 */
@Data
public class SysUser {
    private Long id;
    private String name;
    private String pwd;
    private Integer age;
}
