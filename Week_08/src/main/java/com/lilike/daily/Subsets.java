package com.lilike.daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  子集
 *  https://leetcode-cn.com/problems/subsets/
 * @Author llk
 * @Date 2020/9/20 10:32
 * @Version 1.0
 */
public class Subsets {

    List<List<Integer>> ans = new ArrayList<>();

    /**
     * 采用回溯的方法进行解决
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backTrack(nums,result,0);
        return ans;
    }

    private void backTrack(int[] nums, List<Integer> result, int index) {

        ans.add(new ArrayList<>(result));

        for (int j = index; j < nums.length; j++) {
            result.add(nums[j]);
            backTrack(nums,result,j+1);
            result.remove(result.size()-1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

}




