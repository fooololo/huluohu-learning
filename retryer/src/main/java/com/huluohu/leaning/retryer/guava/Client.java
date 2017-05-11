package com.huluohu.leaning.retryer.guava;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        final Remote remote = new Remote();

        //每次重试之后,都会回调RetryListener
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfException()
                .retryIfResult(Predicates.equalTo(false))
                .withStopStrategy(StopStrategies.stopAfterAttempt(2))
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                .withRetryListener(new ARetryListener<>())
                .withRetryListener(new BRetryListener<>())
                .build();

        try {
            Boolean result = retryer.call(()->remote.request());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(30);
    }
}
