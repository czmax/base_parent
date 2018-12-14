package com.max.code.controller;

import com.max.code.entity.Person;
import com.max.code.entity.XmlActionResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chen
 * @created 2018-12-12-14:56.
 */
@Controller
@RequestMapping("/xml")
public class XmlController {
    @RequestMapping(value = "/person/{name}", produces = {"application/xml; charset=UTF-8"})
    @ResponseBody
    public XmlActionResult helloXmlPerson(@PathVariable("name") String name) {
        /*XmlActionResult<List> actionResult = new XmlActionResult<List>();
        actionResult.setCode("200");
        actionResult.setMessage(name);
        Person person1 = new Person(name+"1", 1, 32);
        Person person2 = new Person(name+"2", 2, 23);
        Person person3 = new Person(name+"3", 3, 24);
        List<Person> persons=new ArrayList<>();
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        actionResult.setData(persons);*/


        XmlActionResult<Person> actionResult = new XmlActionResult<Person>();
        actionResult.setCode("123");
        actionResult.setMessage(name);
        Person person = new Person(name, 1, 32);

        actionResult.setData(person);
        return actionResult;
    }

    @RequestMapping(value = "/persons", produces = {"application/xml; charset=UTF-8"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String xml(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String xmlData =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><xml>"
                        + "<code>123</code>"
                        + "<message>abc</message>"
                        + "<persons>"
                        + "<person>"
                        + "<name>tom1</name>"
                        + "<age>11</age>"
                        + "<sex>男</sex>"
                        + "</person>"
                        + "<person>"
                        + "<name>tom2</name>"
                        + "<age>12</age>"
                        + "<sex>女</sex>"
                        + "</person><person>"
                        + "<name>tom3</name>"
                        + "<age>14</age>"
                        + "<sex>男</sex>"
                        + "</person>" +
                        "<person>"
                        + "<name>tom4</name>"
                        + "<age>15</age>"
                        + "<sex>男</sex>"
                        + "</person>" +
                        "</persons>"
                        + "</xml>";
        return xmlData;
    }


}
