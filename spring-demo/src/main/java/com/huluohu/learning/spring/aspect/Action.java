package com.huluohu.learning.spring.aspect;

import java.lang.annotation.*;

/**
 * Created by huluohu on 2016/5/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {
    String name() default "";
}
