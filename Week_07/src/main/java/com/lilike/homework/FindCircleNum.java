package com.lilike.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 *
 * @Author llk
 * @Date 2020/9/9 14:14
 * @Version 1.0
 */
public class FindCircleNum {

    /** 并查集的方式实现 */
    public int findCircleNum2(int[][] M) {

        UnionFound unionFound = new UnionFound(M.length);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    unionFound.union(i,j);
                }
            }
        }
        return unionFound.getCount();
    }

    /***
     * 一种方法是和岛屿方法类似的DFS的方法,另外一种方法就是采用并查集
     *      我先用DFS的方法复习一下
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {

        boolean[] visited = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                visited[i]=true;
                dfs(M,visited,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] m,boolean[] visited, int i) {
        for (int j = 0; j < m.length; j++) {
            if (m[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(m,visited,j);
            }
        }
    }


    public static void main(String[] args) {

        System.out.println(new FindCircleNum().findCircleNum2(new int[][]{{1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}));

    }

}
