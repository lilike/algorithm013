package com.lilike.homework.five;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *  https://leetcode-cn.com/problems/two-sum/description/
 *
 * @file TwoSum.java
 * @author lyric
 * @date 2020/8/3
 */
public class TwoSum {

    public static void main(String[] args) {

       int[] nums = {2, 1, 8, 15};int target = 10;

        int[] ints = new TwoSum().twoSum(nums, target);

        System.out.println(Arrays.toString(ints));

    }

    /**
     * hash表方式
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.keySet().contains(target - nums[i])) {
                map.put(nums[i],i);
            }else {
                return new int[]{map.get(target - nums[i]),i};
            }
        }
        return null;
    }

}
