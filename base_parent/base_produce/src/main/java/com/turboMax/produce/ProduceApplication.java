package com.turboMax.produce;

import com.turboMax.model.util.redis.RedisCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author Chen
 * @created 2018-12-07-11:18.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProduceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProduceApplication.class, args);
    }

    @Bean
    public RedisCache redisCache(){
        return new RedisCache();
    }

}
