package com.lilike.homework;

import java.util.Arrays;

/**
 * @Author llk
 * @Date 2020/9/16 20:55
 * @Version 1.0
 */
public class SelectSort {

    /**
     * 选择排序,时间复杂度是O(n^2)
     *  原理就是每次选择了一个最小的,放到前面去
     */

    public void selectSort(int[] nums) {

        for (int i = 0; i < nums.length-1; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            // 交换
            int temp = nums[i];
            nums[i] = min;
            nums[index] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {5,3,7,9,2,3,5,1,4};
        new SelectSort().selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }


}
