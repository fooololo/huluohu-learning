package com.huluohu.learning.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huluohu on 2016/5/15.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }
}
