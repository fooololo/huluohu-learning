package com.huluohu.learning.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by huluohu on 2016/5/15.
 */
public class DemoEvent extends ApplicationEvent {
    private String msg;

    public DemoEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

