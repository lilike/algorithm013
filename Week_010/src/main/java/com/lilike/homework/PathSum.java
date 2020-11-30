package com.lilike.homework;

import java.util.*;

/**
 * 路径总和II
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @Author llk
 * @Date 2020/11/30 20:48
 * @Version 1.0
 */
public class PathSum {

    List<List<Integer>> ans = new ArrayList<>();
    Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dg(root,sum);
        return ans;
    }

    private void dg(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        temp.offerLast(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ans.add(new ArrayList<>(temp));
        }
        dg(root.left,sum);
        dg(root.right,sum);
        temp.pollLast();
    }

    public static void main(String[] args) {


    }

}
