package com.lilike.homework.eight;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 子集
 *
 * @Author llk
 * @Date 2020/8/14 15:25
 * @Version 1.0
 */
public class Subsets {

    List<List<Integer>> result = new ArrayList<>();

    /**
     * 最开始是一个空集合
     * 然后依次迭代,让前面的自己里面新增元素,变成一个新子集
     * 把新的子集拷贝到result里面
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        result.add(new ArrayList<>());

        List<List<Integer>> newSubset = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (List<Integer> integers : result) {
                int finalI = i;
                newSubset.add(new ArrayList<Integer>(integers) {{
                    add(nums[finalI]);
                }});
            }
            result.addAll(newSubset);
            newSubset.clear();
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1, 2, 3}));

    }


}
