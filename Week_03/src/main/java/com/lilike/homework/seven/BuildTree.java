package com.lilike.homework.seven;

import com.lilike.daily.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 *  https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *  从前序遍历和中序遍历构造二叉树
 * @Author llk
 * @Date 2020/8/14 10:08
 * @Version 1.0
 */
public class BuildTree {


    public static void main(String[] args) {

        int[] preorder = {1,2,3};
        int[] inorder = {3,2,1};


        System.out.println(new BuildTree().buildTree(preorder,inorder).val);


    }

    private HashMap<Integer,Integer> map = new HashMap<>();

    /**
     * 人脑相比于计算机递归思维弱爆了,所以人脑玩递归,只需要处理好本层的事情就ok了,不要去人肉递归
     * 处理好本层的事情!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
     *
     *前序 所以根节点在最开始[3,9,20,15,7]
     *
     * 中序 所以根节点在中间[9,3,15,20,7]
     *
     *
     * 禁止人肉递归,我只做这一层的事情
     *
     *
     * 取第一个数 3
     *
     * 去第二个数组里面查询到3的索引,三种情况
     * 	3 在中间 , 那么3左边的是左子树, 右边的是右子树  这一部分形成了2个新的数组
     * 	3 [9] [20,15,7]
     * 	[9] 3 [15,20,7]
     *
     * 	依然可以得到左子树的前中序和右子树的前中序
     * 	把左边子树的前中序数组交给下一层,然后右边的前中序也交给下一层,并且要求返回根节点,那么这一层需要返回的是 3 这个节点
     *
     *
     * 得到3的索引,在inorder中, index(3)-leftStartIndex 就是 左子树的长度
     * 在preOrder中 leftStartIndx+左子树的长度 就是 左子树的数组范围
     *
     * 为了节约内存,不要创建数组,直接使用下标,为了方便查询,可以用散列表去保存inOrder中的值和索引
     *
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        int n = preorder.length;
        return _buildTree(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode _buildTree(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex) return null;

        int rootInv = preorder[preStartIndex];
        System.out.println(rootInv);
        TreeNode root = new TreeNode(rootInv);

        Integer inOrderIndex = map.get(rootInv);
        int leftChildNodeSize = inOrderIndex - inStartIndex;

        root.left = _buildTree(preorder,inorder,preStartIndex+1,preStartIndex+leftChildNodeSize,inStartIndex,inStartIndex+leftChildNodeSize-1);
        root.right = _buildTree(preorder,inorder,preStartIndex+leftChildNodeSize+1,preEndIndex,inOrderIndex+1,inEndIndex);
        return root;

    }

}
