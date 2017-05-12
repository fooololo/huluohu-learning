package com.huluohu.learning.statemachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/12.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Autowired
    private StateMachine<States,Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();

        TimeUnit.SECONDS.sleep(3);
        stateMachine.sendEvent(Events.PAY);

        TimeUnit.SECONDS.sleep(3);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
