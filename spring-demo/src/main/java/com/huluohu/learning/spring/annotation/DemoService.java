package com.huluohu.learning.spring.annotation;

import org.springframework.stereotype.Service;

/**
 * Created by huluohu on 2016/5/15.
 */
@Service
public class DemoService {
    public void outputResult(){
        System.out.println("从组合注解配置获得bean");
    }
}
