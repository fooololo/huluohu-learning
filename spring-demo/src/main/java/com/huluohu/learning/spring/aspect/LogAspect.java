package com.huluohu.learning.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by huluohu on 2016/5/15.
 */
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.huluohu.learning.spring.aspect.Action)")
    public void annotationPointCut(){};

    @After("annotationPointCut()")
    public void after(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        if(signature instanceof MethodSignature){
            MethodSignature methodSignature = (MethodSignature)signature;
            Method method = methodSignature.getMethod();
            Action action = method.getAnnotation(Action.class);
            if(action != null){
                System.out.println("注解式拦截：" + action.name());
            }
        }
    }

    @Before("execution(* com.huluohu.learning.spring.aspect.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        if(signature instanceof MethodSignature){
            MethodSignature methodSignature = (MethodSignature)signature;
            Method method = methodSignature.getMethod();
            if(method != null){
                System.out.println("方法规则式拦截：" + method.getName());
            }
        }
    }
}
