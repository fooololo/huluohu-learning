package com.huluohu.leaning.retryer.guava;

import java.util.Random;

/**
 * Created by Administrator on 2017/5/11.
 */
public class Remote {
    public Boolean request() throws Exception {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(String.format("随机数=%s",i));
        if(i > 6){
            return true;
        }else if(i < 4){
            return false;
        }else {
            throw new Exception("出错啦");
        }
    }
}
