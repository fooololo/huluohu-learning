package com.huluohu.learning.property;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Administrator on 2017/5/16.
 */
@SpringBootApplication
public class Client implements CommandLineRunner{
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        SpringApplication.run(Client.class,args);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
