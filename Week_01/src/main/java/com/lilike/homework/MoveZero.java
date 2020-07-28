package com.lilike.homework;

import java.util.Arrays;

/***
 *  https://leetcode-cn.com/problems/move-zeroes/
 *  移动0
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *  输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @file MoveZero.java
 * @author lyric
 * @date 2020/7/28
 */
public class MoveZero {

    public static void main(String[] args) {
        MoveZero moveZero = new MoveZero();

        int[] nums = {0,1,0,3,12};
        moveZero.solution1(nums);

    }


    /**
     *
     *  1. 一个指针不断的往后面探查
     *  2. 另外一个指针指向原来数组里面填充的值的index
     *  3. 最后填充0
     *
     * @param nums
     */
    public void solution1(int[] nums) {

        int rI = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (rI != j) {
                    nums[rI] = nums[j];
                }
                rI++;
            }
        }

        for (int i = rI; i < nums.length; i++) {
            nums[i] = 0;
        }


    }


}
