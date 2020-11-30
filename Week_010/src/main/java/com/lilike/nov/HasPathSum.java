package com.lilike.nov;

import com.lilike.homework.TreeNode;

/**
 *  路径总和
 *  https://leetcode-cn.com/problems/path-sum/
 * @Author llk
 * @Date 2020/11/24 11:55
 * @Version 1.0
 */
public class HasPathSum {

    boolean res = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        dfs(root,0,sum);
        return res;
    }

    private void dfs(TreeNode root, int total,int sum) {
        if (root.left == null && root.right == null) {
            total = total + root.val;
            if (total == sum) {
                res = true;
                return;
            }
        }
        total = total + root.val;
        if (res) {
            return;
        }
        if (root.left != null) dfs(root.left,total,sum);
        if (root.right != null) dfs(root.right,total,sum);
    }

}
