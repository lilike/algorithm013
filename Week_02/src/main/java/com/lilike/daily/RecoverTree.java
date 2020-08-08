package com.lilike.daily;

import com.lilike.homework.six.PreorderTraversal;
import com.lilike.homework.six.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 恢复二叉搜索树
 *
 * @Author llk
 * @Date 2020/8/8 22:00
 * @Version 1.0
 */
public class RecoverTree {

    public static void main(String[] args) {
        TreeNode treeNode = com.lilike.homework.six.TreeNode.generateTree(new Integer[] {
                -1,1,3,null,null,2
        });
        new RecoverTree().recoverTree(treeNode);
        System.out.println(new PreorderTraversal().preorderTraversal(treeNode));
    }

    public void recoverTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        // 1. 首先进行中序遍历
        inorder(root, result);

        // 2. 获取中序遍历结果,找到两个顺序异常的值
        int[] exceptionResult = dealWith(result);


        // 3. 根据这两个值找到对应的节点进行交换
        recoverTreeVal(root, exceptionResult);


    }

    private void recoverTreeVal(TreeNode root, int[] exceptionResult) {
        int x = exceptionResult[0];
        int y = exceptionResult[1];

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int flag = 0;
        while (stack.size() > 0) {
            TreeNode pop = stack.pop();
            if (pop.val == x || pop.val == y) {
                pop.val = pop.val == x ? y : x;
                flag++;
            }
            if (flag == 2) {
                return;
            }

            if (pop.right!= null) {
                stack.push(pop.right);
            }

            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }


    /**  第一种情况 : [ 3, 2 ,1 ]
     *      根据规律可以发现
     *      因为是中序遍历,必然是 An < An+1
     *      第一个 出错的下标是 i 第二个出错的下标是 i+1
     *
     *   还有另外一种情况比如是 [ 2 , 1, 3]
     *   这种情况只能找到 一个 An < An+1
     *   那么另外一个一定就是 n+1了 ,也就是 2和1进行交换了
     *
     *
     * */
    private int[] dealWith(List<Integer> result) {

        Integer xIndex = null;
        Integer x = null, y = null;
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) > result.get(i + 1)) {
                if (x == null) {
                    x = result.get(i);
                    xIndex = i;
                } else {
                    y = result.get(i+1);
                }
            }
        }
        if (y == null) {
            y = result.get(xIndex + 1);
        }
        return new int[]{x, y};
    }

    /**
     * 中序遍历 左 中 右
     *
     * @param root
     * @param result
     */
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }


}

