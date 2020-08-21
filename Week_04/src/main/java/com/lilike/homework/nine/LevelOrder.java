package com.lilike.homework.nine;

import com.lilike.daily.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description
 *
 * @Author llk
 * @Date 2020/8/16 9:17
 * @Version 1.0
 */
public class LevelOrder {

    /**
     * 层序遍历
     *
     * 本质上就是使用BFS,也就是广度优先的遍历方式
     *
     * 但是和广度优先遍历还是有一点点不同,因为要每次打印出来的是每一层的内容
     *
     * 广度优先遍历是一个一个节点往队列里面去添加的.
     *
     * 那么我们就要一次性从队列里面取出这一层的内容,并添加下一层的内容
     *
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) return null;

        List<List<Integer>> res = new ArrayList<>();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (deque.size() != 0) {
            int n = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    deque.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    deque.add(treeNode.right);
                }
            }
            res.add(level);
        }
        return res;

    }

    public static void main(String[] args) {

    }

}
