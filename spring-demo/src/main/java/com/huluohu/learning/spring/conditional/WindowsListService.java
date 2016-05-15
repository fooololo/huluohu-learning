package com.huluohu.learning.spring.conditional;

/**
 * Created by huluohu on 2016/5/15.
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
