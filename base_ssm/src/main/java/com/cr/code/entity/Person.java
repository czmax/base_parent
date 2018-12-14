package com.max.code.entity;

import com.alibaba.fastjson.annotation.JSONField;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author Chen
 * @created 2018-12-12-14:53.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Person {

    @XmlElement
    private String name;
    @XmlElement
    private Integer sex;
    @XmlElement
    private Integer age;

    private Date birthday;

    public Person(String name, Integer sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")//json格式返回的日期格式化注解，日期格式json转换默认是long类型的，如：144101141111111，格式化成yyyy-MM-dd HH:mm:ss格式
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
