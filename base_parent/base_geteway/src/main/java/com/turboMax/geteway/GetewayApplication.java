package com.turboMax.geteway;

/**
 * @author Chen
 * @created 2018-12-06-22:12.
 */

@SpringBootApplication
@EnableZuulProxy
@EnableFeignClients
@EnableDiscoveryClient
public class GetewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetewayApplication.class, args);
    }

}