package com.huluohu.learning.spring.task;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by huluohu on 2016/5/15.
 */
public class Client {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 20; i++) {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
