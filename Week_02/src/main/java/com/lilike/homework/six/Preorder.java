package com.lilike.homework.six;

import java.util.ArrayList;
import java.util.List;


/***
 * N叉树的前序遍历
 *  https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * @file Preorder.java
 * @author lyric
 * @date 2020/8/4
 */
public class Preorder {

    public static void main(String[] args) {


    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<Integer>();
        dg(result,root);
        return result;
    }


    /**
     *  中 -> 左 -> 右
     * @param result
     * @param node
     */
    public void dg(List<Integer> result,Node node) {

        if (node == null) {
            return;
        }

        result.add(node.val);

        if (node.children == null) {
            return;
        }

        for (Node child : node.children) {
            dg(result,child);
        }


    }



}
