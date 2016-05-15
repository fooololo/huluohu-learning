package com.huluohu.learning.spring.init_destory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huluohu on 2016/5/15.
 */
@Configuration
@ComponentScan("com.huluohu.learning.spring.init_destory")
public class SpringConfig {
    @Bean(initMethod = "init",destroyMethod = "destory")
    BeanWayService beanWayService(){
        return new BeanWayService();
    }

    @Bean
    JSR250WayService jsr250WayService(){
        return new JSR250WayService();
    }

}
