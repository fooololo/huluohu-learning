package com.huluohu.learning.sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/2/16.
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {9,2,2,5,7,89,22,1,29,12,34,234,21,56,66,15};
        doSort(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void doSort(int[] nums,int start,int end) {
        if(start < end){
            int middle = getMiddle(nums,start,end);
            doSort(nums,start,middle - 1);
            doSort(nums,middle + 1, end);
        }
    }

    private static int getMiddle(int[] nums, int start, int end) {
        int tmp = nums[start];
        while (start < end){
            while (start < end && nums[end] >= tmp){
                end--;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] <= tmp){
                start++;
            }
            nums[end] = nums[start];
        }
        nums[start] = tmp;
        return start;
    }
}
