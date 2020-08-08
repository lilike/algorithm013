package com.lilike.homework.six;

import java.util.ArrayList;
import java.util.List;

/**
 *  N叉树的后序遍历
 *  https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * @file PostOrder.java
 * @author lyric
 * @date 2020/8/4
 */
public class PostOrder {

    public static void main(String[] args) {



    }


    /**
     * 后序遍历
     *  左 右 中
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        dg(result,root);
        return result;
    }


    public void dg(List<Integer> result,Node node) {

        if (node == null) {
            return;
        }

        List<Node> children = node.children;
        for (Node child : children) {
            dg(result,child);
        }
        result.add(node.val);

    }

}
