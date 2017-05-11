package com.huluohu.leaning.retryer.guava;

import com.github.rholder.retry.Attempt;
import com.github.rholder.retry.RetryListener;

import java.util.concurrent.ExecutionException;

/**
 * Created by Administrator on 2017/5/11.
 */
public class BRetryListener<Boolean> implements RetryListener {
    @Override
    public <Boolean> void onRetry(Attempt<Boolean> attempt) {
        System.out.println("==========BRetryListener start==========");
        System.out.println(String.format("第%s次重试",attempt.getAttemptNumber()));
        System.out.println(String.format("距离第一次重试延迟%s秒",attempt.getDelaySinceFirstAttempt()));

        System.out.println(String.format("是否是异常终止：%s",attempt.hasException()));
        System.out.println(String.format("是否是正常返回：%s",attempt.hasResult()));

        if(attempt.hasException()){
            System.out.println(String.format("导致异常的原因：%s",attempt.getExceptionCause().toString()));
        }else {
            System.out.println(String.format("正常返回的结果：%s",attempt.getResult()));
        }

        try {
            Boolean result = attempt.get();
            System.out.println(String.format("结果：%s",result));
        } catch (ExecutionException e) {
            System.err.println(String.format("发生异常：%s",e.getCause().toString()));
        }
        System.out.println("==========BRetryListener end==========");
    }
}
