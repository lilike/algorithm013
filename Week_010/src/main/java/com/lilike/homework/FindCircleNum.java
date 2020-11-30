package com.lilike.homework;

/**
 *  朋友圈的个数
 *  https://leetcode-cn.com/problems/friend-circles/
 * @Author llk
 * @Date 2020/11/19 21:55
 * @Version 1.0
 */
public class FindCircleNum {

    int count = 0;

    int[] parent;

    public int findCircleNum(int[][] M) {
        int n = M.length;
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (M[i][j] == 1) {
                    union(i,j);
                }
            }
        }
        return count;
    }


    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }

    public int find(int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,1,0},
                                  {1,1,1},
                                  {0,1,1}};
        System.out.println(new FindCircleNum().findCircleNum(arr));
    }

}
