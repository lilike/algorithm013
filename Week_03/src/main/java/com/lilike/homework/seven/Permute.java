package com.lilike.homework.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/permutations/
 * 全排列
 * @Author llk
 * @Date 2020/8/14 13:53
 * @Version 1.0
 */
public class Permute {


    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {

        Permute permute = new Permute();
        permute.permute(new int[]{1,2,3});
        System.out.println(permute.result);
    }

    /**
     * 依然是使用回溯法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        _permute(nums,new Stack<Integer>());
        return result;
    }

    private void _permute(int[] nums, Stack<Integer> stack) {

        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (stack.size() > 0 && stack.contains(nums[j])) continue;
            stack.push(nums[j]);
            _permute(nums,stack);
            stack.pop();
        }
    }




}
