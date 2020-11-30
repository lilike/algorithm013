package com.lilike.nov;

import com.lilike.homework.TreeNode;

/**
 *  完全二叉树的节点个数
 *   https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * @Author llk
 * @Date 2020/11/24 11:35
 * @Version 1.0
 */
public class CountNodes {

    int count = 0;

    /**
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {

        dfs(root);
        return count;

    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        count++;
        dfs(root.right);
    }

}
