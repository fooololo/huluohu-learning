package com.huluohu.learning.spring.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huluohu on 2016/5/15.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();

        context.close();
    }
}
