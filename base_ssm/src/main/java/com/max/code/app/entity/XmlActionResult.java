package com.max.code.app.entity;

import javax.xml.bind.annotation.*;

/**
 * @author Chen
 * @created 2018-12-12-14:52.
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlActionResult<T> extends BaseXmlResult {

    @XmlElements({
            @XmlElement(name = "Person", type = Person.class),
            @XmlElement(name = "Person", type = Person.class),
            @XmlElement(name = "Person", type = Person.class)
    })
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
