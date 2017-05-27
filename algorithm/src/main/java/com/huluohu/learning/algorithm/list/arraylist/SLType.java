package com.huluohu.learning.algorithm.list.arraylist;

/**
 * Created by Administrator on 2017/5/19.
 */
public class SLType {
    static final int MAXLEN = 100;
    DATA[] listData = new DATA[MAXLEN + 1];
    int listLen;

    void SLInit(SLType sl){
        sl.listLen = 0;
    }

    int slLength(SLType sl){
        return sl.listLen;
    }

    int slInsert(SLType sl,int n,DATA data){
        if(sl.listLen >= MAXLEN){
            System.out.println("顺序表已满，不能插入节点！");
            return 0;
        }

        if(n < 1 || n > sl.listLen - 1){
            System.out.println("插入顺序表序号错误，不能插入元素！");
            return 0;
        }

        for (int i = sl.listLen;i >= n;i--){
            sl.listData[i + 1] = sl.listData[i];
        }

        sl.listData[n] = data;
        sl.listLen++;
        return 1;
    }

    int slAdd(SLType sl,DATA data){
        if(sl.listLen >= MAXLEN){
            System.out.println("顺序表已满，不能插入节点！");
            return 0;
        }
        sl.listData[++sl.listLen] = data;
        return 1;
    }

    int slDelete(SLType sl,int n){
        if(n < 1 || n > sl.listLen - 1){
            System.out.println("删除顺序表序号错误，不能删除元素！");
            return 0;
        }

        for (int i = n; i < sl.listLen; i++) {
            sl.listData[i] = sl.listData[i+1];
        }
        sl.listLen--;
        return 1;
    }
}
