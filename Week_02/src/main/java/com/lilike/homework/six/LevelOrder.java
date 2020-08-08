package com.lilike.homework.six;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.List;

/***
 * 层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @file LevelOrder.java
 * @author lyric
 * @date 2020/8/4
 */
public class LevelOrder {

    public static void main(String[] args) {


    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Node> roots = new ArrayList<Node>();
        roots.add(root);
        dg(roots,result);
        return result;
    }

    public void dg(List<Node> children,List<List<Integer>> result) {
        if (children.size() == 0) {
            return;
        }

        List<Node> nextChild = new ArrayList<Node>();
        List<Integer> list = new ArrayList<Integer>();
        for (Node child : children) {
            list.add(child.val);
            if (child.children != null) {
                nextChild.addAll(child.children);
            };
        }
        result.add(list);
        dg(nextChild,result);

    }


}
