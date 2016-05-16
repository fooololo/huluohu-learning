package com.huluohu.learning.spring.fortest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by huluohu on 2016/5/15.
 */
@Configuration
@ComponentScan("com.huluohu.learning.spring.fortest")
public class SpringConfig {
    @Bean
    @Profile("dev")
    public TestBean devTestBean(){
        return new TestBean("from dev profile");
    }

    @Bean
    @Profile("pro")
    public TestBean proTestBean(){
        return new TestBean("from pro profile");
    }
}
