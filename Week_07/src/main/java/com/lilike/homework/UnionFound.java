package com.lilike.homework;

/**
 * 并查集
 *
 *
 * @Author llk
 * @Date 2020/9/9 14:49
 * @Version 1.0
 */
public class UnionFound {

    int[] parent;
    int count;

    public UnionFound(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    /**
     * 找到某个元素的代表
     * @param p
     * @return
     */
    public int find(int p) {

        while (parent[p] != p ) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

    /** 合并两个元素 */
    public void union(int x , int y) {
        int i = find(x);
        int j = find(y);
        if (i != j) {
            parent[i] = j;
            count--;
        }
    }

    /** 获取到朋友圈的数量 */
    public int getCount() {
        return count;
    }




}
