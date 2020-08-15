package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 *  https://leetcode-cn.com/problems/validate-binary-search-tree/
 *  验证二叉搜索树
 * @Author llk
 * @Date 2020/8/10 20:59
 * @Version 1.0
 */
public class IsValidBST {

    public static void main(String[] args) {

    }

    /**
     * 验证二叉搜索树有两个思路:
     *  1. 中序遍历,遍历结果如果是从小到大递增的,说明是二叉搜索树
     *  2. 递归检查,设定一个树木节点的上界和下界
     *          左树 < 上界
     *          右树 > 下界
     *  3. 二叉搜索树不能有相同的值
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        return helper(root,null,null);
    }


    public boolean helper(TreeNode root,Integer lower,Integer upper) {

        // 递归出来
        if (root == null) return true;

        // 处理逻辑
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;

        // 递归
        if (!helper(root.left,lower,root.val)) return false;
        if (!helper(root.right,root.val,upper)) return false;
        return true;
    }

    public boolean isValidBST2(TreeNode root) {

        // 中序遍历
        List<Integer> result = new ArrayList<>();
        recursion(root,result);
        boolean flag = true;
        for (int i = 0; i < result.size()-1; i++) {
            if (result.get(i) >= result.get(i+1)) {
                flag = false;
                break;
            }
        }
        return flag;
    }


    public void recursion(TreeNode root, List<Integer> result) {

        // 递归终止
        if (root == null) return;

        // 本层业务逻辑处理
        recursion(root.left,result);
        result.add(root.val);
        recursion(root.right,result);
    }


}
