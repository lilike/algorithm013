package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;

/**
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 二叉树的最小深度
 *
 * @Author llk
 * @Date 2020/8/11 9:14
 * @Version 1.0
 */
public class MinDepth {

    public static void main(String[] args) {

    }


    /**
     * 递归找到当前树木节点的最小深度
     * 1. 如果当前节点是空,那么当前层节点深度为0
     * 2. 如果当前节点左子树和右子树都为null,那么返回1,当前层的节点深度为1
     * 3. 如果当前节点左子树不为null,那么就找左子树的最小深度
     * 4. 如果当前节点右子树不为null,就找右子树的最小深度
     *
     * @param root
     * @return
     */

    /**
     * 关键在于有没有到叶子节点
     */

    public int minDepth(TreeNode root) {

        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int min_flag = Integer.MAX_VALUE;
        if (root.left != null) {
            min_flag = Math.min(minDepth(root.left),min_flag);
        }
        if (root.right != null) {
            min_flag = Math.min(minDepth(root.right),min_flag);
        }
        return min_flag+1;

    }

}
