package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *  https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *  二叉树的序列化与反序列化
 *
 * @Author llk
 * @Date 2020/8/13 9:09
 * @Version 1.0
 */
public class DfsCodec {

    /**
     * 广度优先虽然实现了,但是非常消耗内存,因为是使用数组来存储,为了能够保证每个节点都能找到父亲节点,所以数组中保留了很多空元素
     * 只能使用深度优先算法
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfs(root,list);
        return list.stream().collect(Collectors.joining(","));
    }

    private void dfs(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }

        list.add(root.val+"");
        dfs(root.left,list);
        dfs(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] split = data.split(",");
        TreeNode treeNode = dfsDesrialize(new LinkedList<>(Arrays.asList(split)));
        return treeNode;
    }

    private TreeNode dfsDesrialize(List<String> asList) {
        if (asList.size() == 0) {
            return null;
        }
        String remove = asList.remove(0);
        if ("null".equals(remove)) return null;

        TreeNode root = new TreeNode(Integer.valueOf(remove));
        root.left = dfsDesrialize(asList);
        root.right = dfsDesrialize(asList);
        return root;
    }

    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        TreeNode t4 = new TreeNode(4);
        TreeNode t22 = new TreeNode(2);
        TreeNode t33 = new TreeNode(3);
        TreeNode t11 = new TreeNode(1);

        t5.left = t2;
        t5.right = t3;
        t3.left = t22;
        t22.left = t33;
        t22.right = t11;
        t3.right = t4;
        System.out.println(new DfsCodec().serialize(t5));
        TreeNode deserialize = new DfsCodec().deserialize("5,2,null,null,3,2,3,null,null,1,null,null,4,null,null");
        System.out.println(new DfsCodec().serialize(deserialize));


    }
}
