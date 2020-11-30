package com.lilike.nov;

import java.util.Arrays;

/**
 *  移动零
 *  https://leetcode-cn.com/problems/move-zeroes/
 * @Author llk
 * @Date 2020/11/19 10:00
 * @Version 1.0
 */
public class MoveZeroes {

    /**
     * 使用一个指针指向当前的0的位置
     * 另外一个指针往前开始试探,如果遇到非0的位置,就进行交换
     * 
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i =0,j = 0;

        while (i < nums.length && j < nums.length) {

            // i 先找到0的位置
            while (i < nums.length && nums[i] != 0) {
                i++;
            }

            j = i + 1;
            while (j < nums.length && nums[j] == 0) {
                j++;
            }

            if (i < nums.length && j < nums.length) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
