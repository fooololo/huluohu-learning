package com.huluohu.learning.spring.init_destory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by huluohu on 2016/5/15.
 */
public class JSR250WayService {
    public JSR250WayService() {
        System.out.println("JSR250WayService构造函数");
    }

    @PostConstruct
    public void init(){
        System.out.println("JSR250-init-method");
    }

    @PreDestroy
    public void destory(){
        System.out.println("JSR250-destory-method");
    }
}
