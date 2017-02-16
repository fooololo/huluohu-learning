package com.huluohu.learning.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/16.
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {9,2,2,5,7,89,22,1};
        doSort(nums);
    }

    private static void doSort(int[] nums) {
        int temp;
        int size = nums.length;

        for (int i = 0; i < size -1; i++) {
            for (int j = i + 1; j < size; j++) {
                if(nums[i] < nums[j]){
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
