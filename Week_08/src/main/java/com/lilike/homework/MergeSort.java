package com.lilike.homework;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/9/17 21:07
 * @Version 1.0
 */
public class MergeSort {

    /**
     * 归并排序
     * @param nums
     */
    public void mergeSort(int[] nums) {
        if (nums == null && nums.length > 0) return;
        mergeSort(nums,0,nums.length-1);
    }

    private void mergeSort(int[] nums, int begin, int end) {
        if (end <= begin) return;
        int middle = (begin + end) >> 1;
        mergeSort(nums,begin,middle);
        mergeSort(nums,middle+1,end);
        merge(nums,begin,middle,end);
    }

    private void merge(int[] nums, int begin, int middle, int end) {
        int[] tempNums = new int[end-begin+1];
        int i = begin,j=middle+1,k=0;
        while (i <= middle && j <= end) {
            tempNums[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= middle) tempNums[k++] = nums[i++];
        while (j <= end) tempNums[k++] = nums[j++];
        for (int l = 0; l < tempNums.length; l++) {
            nums[begin+l] = tempNums[l];
        }
    }


    public static void main(String[] args) {
        int[] nums = {5,3,7,9,2,3,5,1,4};
        new MergeSort().mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
