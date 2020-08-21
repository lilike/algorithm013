package com.lilike.homework.nine;

import com.lilike.daily.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description
 *  在每一颗树行中找最大值
 * @Author llk
 * @Date 2020/8/17 16:41
 * @Version 1.0
 */
public class LargestValues {

    /**
     * 广度优先遍历
     * 和层序遍历的那一道题目很像,不过就是在层序遍历中找到这一层的最大值罢了
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);

        while (deque.size() > 0) {
            int size = deque.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode tree = deque.poll();
                max = Math.max(tree.val,max);
                if (tree.left != null) deque.add(tree.left);
                if (tree.right != null) deque.add(tree.right);
            }
            result.add(max);
        }
        return result;
    }

}
