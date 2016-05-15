package com.huluohu.learning.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by huluohu on 2016/5/15.
 */
@Configuration
@ComponentScan("com.huluohu.learning.spring.profile")
public class SpringConfig {

    @Bean
    @Profile("dev")
    public DemoBean devDemoBean(){
        return new DemoBean("from dev profile");
    }

    @Bean
    @Profile("pro")
    public DemoBean proDemoBean(){
        return new DemoBean("from pro profile");
    }
}
