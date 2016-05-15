package com.huluohu.learning.spring.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huluohu on 2016/5/15.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");

        context.close();
    }
}
