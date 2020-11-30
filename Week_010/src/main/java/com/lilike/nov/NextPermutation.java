package com.lilike.nov;

import java.util.Arrays;

/**
 *  下一个排列
 *  https://leetcode-cn.com/problems/next-permutation/
 * @Author llk
 * @Date 2020/11/10 15:53
 * @Version 1.0
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[i] >= nums[j]) j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);


    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums,i++,j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }

}
