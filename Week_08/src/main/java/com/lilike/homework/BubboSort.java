package com.lilike.homework;

import java.io.BufferedReader;
import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @Author llk
 * @Date 2020/9/16 21:01
 * @Version 1.0
 */
public class BubboSort {


    /**
     * 冒泡排序
     *  冒泡排序的时间复杂度也是O(n^2)的
     *   原理就是
     *      不断的进行两两交换,把大的放在后面
     *      这样经过一轮之后,最后面一个就是最大的,以此类推
     * @param nums
     */
    public void bubboSort(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                   if (nums[j] > nums[j+1]) {
                       int temp = nums[j];
                       nums[j] = nums[j+1];
                       nums[j+1] = temp;
                   }
            }
        }
    }


    public static void main(String[] args) {


        int[] nums = {5,3,7,9,2,3,5,1,4};
        new BubboSort().bubboSort(nums);
        System.out.println(Arrays.toString(nums));
    }



}
