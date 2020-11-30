package com.lilike.homework;


/**
 *  求根到叶子节点数字之和
 *  https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/
 * @Author llk
 * @Date 2020/10/29 8:56
 * @Version 1.0
 */
public class SumNumbers {

    int sum = 0;
    /**
     * 使用一个前序遍历即可
     * @param root
     */
    public int sumNumbers(TreeNode root) {
        preDfs(root,0);
        return sum;
    }

    private void preDfs(TreeNode root,Integer current) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            sum += (current*10 + root.val);
            return;
        }
        preDfs(root.left,current*10 + root.val);
        preDfs(root.right,current*10 + root.val);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(new SumNumbers().sumNumbers(root));


    }

}
