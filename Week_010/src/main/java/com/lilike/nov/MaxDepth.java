package com.lilike.nov;

import com.lilike.homework.TreeNode;

/**
 *  二叉树的最大深度
 *  https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * @Author llk
 * @Date 2020/11/24 11:49
 * @Version 1.0
 */
public class MaxDepth {

    /**
     * 二叉树的最大深度 使用
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }

    private int maxDepth(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count++;
        int left = maxDepth(root.left,count);
        int right = maxDepth(root.right,count);
        return Math.max(left,right);
    }

}
