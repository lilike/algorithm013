package com.lilike.homework;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 快速排序
 *
 * @Author llk
 * @Date 2020/9/16 21:59
 * @Version 1.0
 */
public class QuickSort {

    /**
     * 快速排序
     * 原理就是找到一个 找到一个pivot
     * 然后数组变成两边, 一边是 小于pivot的数, 另外一个边是 大于 pivot的数字
     * 然后递归调用即可
     *
     * @param nums
     */
    public void quickSort(int[] nums) {
        dg(nums, 0, nums.length - 1);
    }

    private void dg(int[] nums, int start, int end) {

        if (start > end) return;
        int pivot = partition(nums,start,end);
        dg(nums,start,pivot-1);
        dg(nums,pivot+1,end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = end,counter = start;

        for (int i = start; i < end; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums,counter,i);
                counter++;
            }
        }

        swap(nums,counter,pivot);
        return counter;
    }

    private void swap(int[] nums, int counter, int i) {
        int temp = nums[counter];
        nums[counter] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {

        int[] nums = {5, 3, 7, 9, 2, 3, 5, 1, 4};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
