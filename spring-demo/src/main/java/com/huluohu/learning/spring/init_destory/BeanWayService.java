package com.huluohu.learning.spring.init_destory;

/**
 * Created by huluohu on 2016/5/15.
 */
public class BeanWayService {
    public BeanWayService() {
        System.out.println("BeanWayService构造函数");
    }

    public void init(){
        System.out.println("@Bean-init-method");
    }

    public void destory(){
        System.out.println("@Bean-destory-method");
    }
}
