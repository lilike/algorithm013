package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.awt.print.Pageable;
import java.util.*;

/**
 * 二叉树的序列化与反序列化
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 有点难-------------------------------------------
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 *
 * @Author llk
 * @Date 2020/8/11 10:15
 * @Version 1.0
 */
public class BfsCodec {


    /**
     * 这个题目可以用深度搜索和广度搜索做出来
     * 广度搜索的话,需要首先计算一次TreeNode的最大深度,然后创建对应容量的数组
     * 然后根据父亲节点的下标,计算出儿子的下标,然后填入到数组里面,生成字符串
     * 再根据字符串还原反序列化就很容易了
     * 广度优先的缺点就是非常消耗内存,所以是不可取的
     * 采用深度优先的算法更加的划算
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {

        if (root == null) {
            return null;
        }

        // 1. 计算最大深度
        int h = getHight(root, 0);

        // 2. 计算出对应的数组
        Integer count = Integer.valueOf((int) (Math.pow(2, h) - 1));
        Integer[] r = new Integer[count];

        int fIndex = 0;

        Deque<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.addLast(root);
        r[fIndex] = root.val;

        forloop(treeNodes,fIndex,r);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : r) {
            sb.append(integer+",");
        }
        return sb.toString();
    }

    private void forloop(Deque<TreeNode> treeNodes, int fIndex, Integer[] r) {

        // terminator
        if (treeNodes.size() == 0) {
            return;
        }

        TreeNode root = treeNodes.poll();
        if (root.left != null) {
            r[fIndex*2+1] = root.left.val;
            treeNodes.addFirst(root.left);
            forloop(treeNodes,fIndex*2+1,r);
        }


        if (root.right != null) {
            r[fIndex*2+2] = root.right.val;
            treeNodes.addFirst(root.right);
            forloop(treeNodes,fIndex*2+2,r);
        }



    }




    private int getHight(TreeNode root, int n) {
        if (root == null) return n;
        return Math.max(getHight(root.left, n + 1), getHight(root.right, n + 1));
    }


    public TreeNode deserialize(String data) {

        if ( data == null || data.length() == 0) return null;
        String[] treeNodeStr = data.split(",");

        TreeNode[] treeNodes = new TreeNode[treeNodeStr.length];

        for (int i = 0; i < treeNodeStr.length; i++) {
            if ("null".equals(treeNodeStr[i])) {
                continue;
            }else {
                TreeNode treeNode = new TreeNode(Integer.valueOf(treeNodeStr[i]));
                treeNodes[i] = treeNode;
                if (i==0) continue;
                // 找父亲
                if (i%2==0) {
                    treeNodes[(i-2)/2].right = treeNode;
                }else {
                    treeNodes[(i-1)/2].left = treeNode;
                }
            }
        }



        return treeNodes[0];
    }


    public static void main(String[] args) {

    }


}
