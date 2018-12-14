package com.max.code.sys.common.config.swagger;

/**
 * 集成Swagger2的页面配置
 *
 * @author Chen
 * @created 2018-12-14-19:44.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//@Configuration //这里需要注意，如果项目架构是SSM，那就不要加这个注解，如果是 spring boot 架构类型的项目，就必须加上这个注解，让 spring 加载该配置。
@EnableWebMvc // spring boot 项目不需要添加此注解，SSM 项目需要加上此注解，否则将会报错。
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInfo())
                .select().apis(RequestHandlerSelectors.basePackage("com.max.code.sys.controller"))// controller路径。
                .paths(PathSelectors.any())
                .build();
    }

    // 配置 API 文档标题、描述、作者等等相关信息。
    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("前后端分离系统API接口文档")
                .termsOfServiceUrl("")
                .description("Spring MVC中使用Swagger2构建Restful API")
                .build();

    }


}
