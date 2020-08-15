package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @Author llk
 * @Date 2020/8/13 11:21
 * @Version 1.0
 */
public class LowestCommonAncestor {


    /**
     * 先把P的全路径找出来,然后遍历q的时候,找p就可以了,但是这种方法超出内存限制
     *
     * 使用后续遍历的方法来找 左边 -- 右边 -- 中
     *
     *      使用递归,四种情况
     *          1. 当前节点为空,表示 p 和 q 不在 该节点,return null
     *          2. 当前节点等于 p 或是 q ,返回当前节点
     *          3. 当前节点不等于 p 或是 q ,返回null
     *          4. 如果这个节点的左右节点都不为空,则是返回该节点
     *          5. 如果这个节点的左节点为空,右边不为空,说明右边有找到p或是q,返回右边,同理如果左边不为空返回左边
     *          6. 如果左右都为空,返回null
     *
     *
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == q || root == p || root ==null) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        /** 一定不在左边 */
        if (left == null)  return right;
        /** 一定不在右边 */
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {


    }
}
