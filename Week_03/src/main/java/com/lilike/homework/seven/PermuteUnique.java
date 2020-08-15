package com.lilike.homework.seven;

import java.util.*;

/**
 * 全排列II
 * https://leetcode-cn.com/problems/permutations-ii/
 *
 * @Author llk
 * @Date 2020/8/14 14:10
 * @Version 1.0
 */
public class PermuteUnique {

    List<List<Integer>> result = new ArrayList<>();
    Set<String> set = new HashSet<>();


    /**
     * 在全排1的基础上
     *
     * 当得到一个结果的时候,去result里面搜索是否存在这个结果,如果存在,就跳过
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        _permute(nums, new Stack<Integer>(),new HashSet<Integer>());
        return result;
    }

    private void _permute(int[] nums, Stack<Integer> stack, Set<Integer> indexSet) {

        if (stack.size() == nums.length) {
            ArrayList<Integer> re = new ArrayList<>(stack);
            String s = Arrays.toString(re.toArray());
            if (set.contains(s)) return;
            set.add(s);
            result.add(re);
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (stack.size() > 0 && indexSet.contains(j)) continue;
            stack.push(nums[j]);
            indexSet.add(j);
            _permute(nums, stack,indexSet);
            stack.pop();
            indexSet.remove(j);
        }
    }

    public static void main(String[] args) {

    }


}
