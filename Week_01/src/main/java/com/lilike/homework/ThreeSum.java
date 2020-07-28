package com.lilike.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 * <p>
 * 需要三个指针
 * <p>
 * 首先选定中间的那个指针
 * <p>
 * 分别指向 [2,n-1] 的索引
 * <p>
 * 如果 这个索引的值 > target , 那么就直接跳过往下一个
 * <p>
 * 如果没有的话,三数相加 得到一个 sum
 * <p>
 * 如果 sum > target 那么右边的左移
 * 如果 sum < target 左边右移
 * <p>
 * 跳出循环的条件就是 指针碰撞 或是 已经找到了结果
 *
 * @author lyric
 * @file ThreeSum.java
 * @date 2020/7/28
 */
public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.solution1(nums));;


    }


    public List<List<Integer>> solution1(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }


        // 排序
        Arrays.sort(nums);

        /**
         *  双指针
         *      一个left 一个right
         *
         *
         * */

        for (int left = 0; left < nums.length - 1; left++) {

            if (left> 0 && nums[left] == nums[left-1]) {
                continue;
            }

            if (nums[left] > 0) {
                break;
            }

            // 定死了左边的数,右边两个数相加等于这个数*-1
            int target = - nums[left];

            int middle = left + 1;
            int right = nums.length - 1;

            while (middle < right) {

                if (nums[middle] + nums[right] == target) {
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[left]);
                    res.add(nums[middle]);
                    res.add(nums[right]);
                    result.add(res);
                    // 但是不能重复,但是还有可能有不同的值
                    middle++;
                    right--;

                    while (middle < right && nums[middle] == nums[middle-1]) {
                        middle++;
                    }
                    while (middle < right && nums[right] == nums[right+1]) {
                        right--;
                    }




                }else if (nums[middle] + nums[right] > target) {
                    right--;
                }else {
                    middle++;
                }




            }



        }


        return result;
    }

}
