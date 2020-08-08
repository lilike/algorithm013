package com.lilike.homework.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树前序遍历
 *
 * @file PreorderTraversal.java
 * @author lyric
 * @date 2020/8/4
 */
public class PreorderTraversal {

    public static void main(String[] args) {

        TreeNode treeNode = TreeNode.generateTree(new Integer[] {
           -1,1,null,2,null,null,3
        });

        System.out.println(new PreorderTraversal().preorderTraversal(treeNode));

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dg(root,res);
        return res;
    }

    public void dg(TreeNode node,List<Integer> result) {

        if (node == null) {
            return;
        }

        result.add(node.val);

        if (node.left != null){
            dg(node.left,result);
        }

        if (node.right != null) {
            dg(node.right,result);
        }



    }

}
