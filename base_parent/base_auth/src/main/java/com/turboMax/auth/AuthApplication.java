package com.turboMax.auth;

import com.turboMax.model.util.redis.RedisCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Chen
 * @created 2018-12-06-21:57.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
    /**
     * 注入RedisCache工具类
     * @return
     */
    @Bean
    public RedisCache redisCache(){
        return new RedisCache();
    }

}
