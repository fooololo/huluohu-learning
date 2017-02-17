package com.huluohu.learning.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/16.
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {9,2,2,5,7,89,22,1,29,12,34,234,21,56,66,15};
        doSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void doSort(int[] nums) {
        int size = nums.length;
        int tmp;
        int j;
        for (int i = 1; i < size; i++) {
            if(nums[i]  < nums[i - 1]){
                tmp = nums[i];
                for (j = i; j > 0 && tmp < nums[j -1 ]; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[j] = tmp;
            }
        }

    }
}
