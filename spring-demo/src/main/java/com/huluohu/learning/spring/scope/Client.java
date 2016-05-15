package com.huluohu.learning.spring.scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huluohu on 2016/5/15.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);


        DemoSingletonService s1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService s2 = context.getBean(DemoSingletonService.class);

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);

        System.out.println("s1=s2:" + (s1 == s2));
        System.out.println("p1=p2:" + (p1 == p2));

        context.close();
    }
}
