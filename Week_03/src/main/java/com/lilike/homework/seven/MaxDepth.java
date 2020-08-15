package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 二叉树的最大高度
 *
 * @Author llk
 * @Date 2020/8/11 9:05
 * @Version 1.0
 */
public class MaxDepth {


    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }


    public int maxDepth(TreeNode root, int current) {

        if (root == null) {
            return current;
        }

        current++;

        int left = maxDepth(root.left,current);
        int right = maxDepth(root.right,current);
        return Math.max(left,right);
    }


    public static void main(String[] args) {

    }

}
