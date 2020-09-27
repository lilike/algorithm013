package com.lilike.daily;

import javax.swing.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/sum-of-left-leaves/
 *
 * @Author llk
 * @Date 2020/9/19 17:47
 * @Version 1.0
 */
public class SumOfLeftLeaves {

    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        dg(root);
        return ans;
    }


    private void dg(TreeNode root) {
        // terminator
        if (root == null)return;

        // porcess current logic
        if (root.left != null && root.left.left == null && root.left.right == null) ans+= root.left.val;
        dg(root.left);
        dg(root.right);

    }

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
