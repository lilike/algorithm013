package com.lilike.homework;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/rotate-array/
 * 旋转数组
 * @file Rotate.java
 * @author lyric
 * @date 2020/8/2
 */
public class Rotate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Rotate rotate = new Rotate();
        rotate.rotate2(nums,3);

        System.out.println(Arrays.toString(nums));
    }


    /**
     *  反转的方法
     *  假设反转了 n 次
     *  那么 n % nums.length 放到了元素的前面
     *   1. 反转整个数组
     *   2. 反转前面n个数组
     *   3. 反转后面nums.length - n 个数组
     *
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }


    public void reverse(int[] nums,int start,int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }








    /*
        k 是 旋转n 次
        我们只需要写出旋转1次的代码
        然后迭代就可以
     */
    public void rotate1(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int lastNum = nums[nums.length - 1];
            for (int j = nums.length-1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = lastNum;
        }

    }

}
