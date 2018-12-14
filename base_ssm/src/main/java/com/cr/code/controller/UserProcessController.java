package com.max.code.controller;


import com.max.code.entity.User;
import com.max.code.service.UserProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserProcessController {

    @Autowired
    private UserProcessService userProcessService;

    @RequestMapping("/hello")
    public String index(Model model) {
        User user = new User();
        user.setId(1);
        user.setName("aaa");
        user.setAge(11);
        User user2 = new User();
        user2.setId(2);
        user2.setName("bbb");
        user2.setAge(12);
        User user3 = new User();
        user3.setId(3);
        user3.setName("ccc");
        user3.setAge(13);

        List list = new ArrayList();
        list.add(user);
        list.add(user2);
        list.add(user3);
        model.addAllAttributes(list);

        return "index";
    }

}
