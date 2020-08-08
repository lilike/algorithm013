package com.lilike.homework.six;

import java.util.HashMap;
import java.util.Map;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode generateTree(Integer[] nums) {
        Map<Integer,TreeNode> map = new HashMap<Integer, TreeNode>();
        TreeNode root = new TreeNode(nums[1]);
        map.put(1,root);

        for (int i = 2; i < nums.length; i++) {

            if (nums[i]==null) {
                continue;
            }
            TreeNode node = new TreeNode(nums[i]);
            map.put(i,node);
            if (i % 2 == 0) {
                map.get(i/2).left = node;
            }else {
                map.get((i-1)/2).right = node;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {-1,1,null,2,null,null,3};

        TreeNode treeNode = generateTree(nums);
        System.out.println(treeNode);
    }



}
