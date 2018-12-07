package com.turbomax.show.common.config.mvc;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * springMVC的配置
 *
 * @author Chen
 * @created 2018-12-07-14:50.
 */
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    /**
     * 重写方法描述：实现在url中输入相应的地址的时候直接跳转到某个地址
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //  跳转到登陆页
        registry.addViewController("/login").setViewName("login");
        // 登陆成功跳转到首页
        registry.addViewController("/main").setViewName("main");
        // 登陆成功tab首页
        registry.addViewController("/home").setViewName("home");

    }


}
