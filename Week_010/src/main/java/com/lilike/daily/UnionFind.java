package com.lilike.daily;

/**
 *  并查集其实就是解决朋友圈问题
 *      这种衍生的数据结构就是为了判断某些人是不是一个圈子的
 *
 *
 * @Author llk
 * @Date 2020/11/19 16:36
 * @Version 1.0
 */
public class UnionFind {

    // 圈子数量
    private int count = 0;

    private int[] parent;

    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[count] = count;
        }
    }

    /**
     * 找老大
     * @param i
     * @return
     */
    public int find(int i) {

        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public void union (int p,int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        parent[rootP] = rootQ;
        count--;

    }


}