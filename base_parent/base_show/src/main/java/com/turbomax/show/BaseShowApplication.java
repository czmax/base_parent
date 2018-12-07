package com.turbomax.show;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Chen
 * @created 2018-12-07-14:52.
 */
@SpringBootApplication
public class BaseShowApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseShowApplication.class, args);
    }

    @Bean
    public RedisCache redisCache() {
        return new RedisCache();
    }


}
