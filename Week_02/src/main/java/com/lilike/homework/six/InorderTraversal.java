package com.lilike.homework.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @file InorderTraversal.java
 * @author lyric
 * @date 2020/8/4
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.generateTree(new Integer[]{-1, 1, null, 2, null, null, 3});
        List<Integer> integers = new InorderTraversal().inorderTraversal(treeNode);
        System.out.println(integers);
    }



    /**
     * 中序遍历 : 左 -> 中 -> 右
     * 递归
     *
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        dg(result,root);
        return result;
    }


    public void dg(List<Integer> result,TreeNode node) {

        if (node == null) {
            return;
        }

        // 左边
        if (node.left!=null) {
            dg(result,node.left);
        }

        // 中间
        result.add(node.val);

        // 右边
        if (node.right!=null) {
            dg(result,node.right);
        }




    }


}
