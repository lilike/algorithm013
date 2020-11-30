package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 *  等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * @Author llk
 * @Date 2020/10/30 17:12
 * @Version 1.0
 */
public class EquationsPossible {

    int[] parent = new int[26];


    /**
     *  使用并查集就可以解决了
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {

        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                union(a,b);
            }
        }

        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                if (find(a) == find(b)) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 把 p 并入 到 q 的圈子
     * @param p
     * @param q
     */
    public void union(int p , int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
    }

    public int find (int p) {
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }



}
