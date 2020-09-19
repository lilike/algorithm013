package com.lilike.homework;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 插入排序
 *
 * @Author llk
 * @Date 2020/9/16 21:06
 * @Version 1.0
 */
public class InsectionSort {


    /**
     * 插入排序
     *  原理就是把之前的看成是有序的数组,然后插入到这个有序数组当中去
     *
     * @param nums
     */
    public void insertionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int index = i;
            for (int j = i-1; j >= 0; j--) {
                if (num < nums[j]) {
                    // i 和 j 对调
                    int temp = nums[j];
                    nums[j] = num;
                    nums[index] = temp;
                    index = j;
                }
            }
        }
    }



    public static void main(String[] args) {

        int[] nums = {5,3,7,9,2,3,5,1,4};
        new InsectionSort().insertionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
