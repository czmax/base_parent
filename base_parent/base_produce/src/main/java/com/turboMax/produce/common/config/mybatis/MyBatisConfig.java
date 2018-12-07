package com.turboMax.produce.common.config.mybatis;

import org.springframework.context.annotation.Configuration;

/**
 *  * 类描述：开启mybatis的支持
 * @author Chen
 * @created 2018-12-07-13:49.
 */

@Configuration
@MapperScan("com.produce.*.dao")
public class MyBatisConfig {


}
