package com.turbomax.entity;


import com.turbomax.common.QueryBase;

/**
 * @author linzf
 **/
public class QueryDept extends QueryBase {
    private Long existingNum;
    private String deptCode;
    private String name;
    private String node;
    private Long num;
    private String parentNode;

    public Long getExistingNum() {
        return existingNum;
    }

    public void setExistingNum(Long existingNum) {
        this.existingNum = existingNum;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

}
