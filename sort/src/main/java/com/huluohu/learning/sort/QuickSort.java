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
        int tmp = nums[start];//数组的第一个作为中轴
        while (start < end){
            while (start < end && nums[end] >= tmp){
                end--;
            }
            nums[start] = nums[end];//比中轴小的记录移到低端
            while (start < end && nums[start] <= tmp){
                start++;
            }
            nums[end] = nums[start];//比中轴大的记录移到高端
        }
        nums[start] = tmp;
        return start;
    }
}
