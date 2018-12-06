package com.turboMax.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Chen
 * @created 2018-12-06-21:31.
 */
@SpringBootApplication
@EnableEurekaServer
public class BaseRegistryCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseRegistryCenterApplication.class, args);
    }

}
