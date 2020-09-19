package com.lilike.homework;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/9/19 15:57
 * @Version 1.0
 */
public class ReversePairs {

    /**
     * 使用归并排序的方式进行
     *
     * @param nums
     * @return
     */
    int ret  = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return ret;
    }

    private void mergeSort(int[] nums, int start, int end) {
        System.out.println(start + "============" + end);
        if (start >= end) return;

        int middle = (start + end) >> 1;
        mergeSort(nums,start,middle);
        mergeSort(nums,middle+1,end);
        merge(nums,start,middle,end);
    }

    private void merge(int[] nums, int start, int middle, int end) {
        int count = 0;

        for (int i = start, j = middle + 1 ; i < middle+1; ) {
            if (j > end || (long)nums[i] <= (long)nums[j]) {
                i++;
                ret+=count;
            }else{
                count++;
                j++;
            }

        }

        Arrays.sort(nums,start,end+1);

    }

    public static void main(String[] args) {
        int[] demo = {1,3,2,3,1};
        int i = new ReversePairs().reversePairs(demo);
        System.out.println(i);
        System.out.println(Arrays.toString(demo));


    }

}
