package com.huluohu.learning.spring.aspect;

import org.springframework.stereotype.Service;

/**
 * Created by huluohu on 2016/5/15.
 */

@Service
public class DemoAnnotationService {
    @Action(name = "注解式拦截ADD操作")
    public void add(){

    }
}
