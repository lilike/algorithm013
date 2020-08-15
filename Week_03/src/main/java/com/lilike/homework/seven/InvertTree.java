package com.lilike.homework.seven;


import com.lilike.daily.TreeNode;

/**
 * @Author llk
 * @Date 2020/8/10 20:36
 * @Version 1.0
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        dg(root);
        return root;
    }


    /**
     * 递归反转
     * @param node
     */
    public void dg(TreeNode node) {

        // 递归终止条件
        if (node == null) {
            return;
        }

        // 本层业务逻辑处理
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        // 递归到下面一层
        dg(node.left);
        dg(node.right);
    }



    public static void main(String[] args) {





    }


}
