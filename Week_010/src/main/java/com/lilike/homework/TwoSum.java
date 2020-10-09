package com.lilike.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和
 *  https://leetcode-cn.com/problems/two-sum/
 * @Author llk
 * @Date 2020/10/7 11:46
 * @Version 1.0
 */
public class TwoSum {

    /**
     * 一次遍历,使用了一个辅助的map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.keySet().contains(target-nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{ 2, 7, 11, 15};
        System.out.println(Arrays.toString(new TwoSum().twoSum(nums,9)));

    }

}
