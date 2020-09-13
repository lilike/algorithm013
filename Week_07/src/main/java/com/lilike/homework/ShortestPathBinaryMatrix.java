package com.lilike.homework;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二进制矩阵中的最短路径
 * https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 *
 * @Author llk
 * @Date 2020/9/13 15:27
 * @Version 1.0
 */
public class ShortestPathBinaryMatrix {


    /***
     *  采用BFS的方法来进行处理
     *
     *   由第一个节点开始,以8连通的方式开始向外面扩充
     *   直到遇到最后一个节点
     *
     *
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {

        // 八联通数组
        int[][] eightTong = new int[][]{
                {-1,0},{-1,1},{0,1},{1,1},
                {1,0},{1,-1},{0,-1},{-1,-1}
        };



        if (grid == null || grid.length == 0) return -1;
        int nr = grid.length;
        int nc = grid[0].length;
        if (grid[0][0] == 1 || grid[nr-1][nc-1] == 1) return -1;
        if (0 == nr-1 && 0 == nc -1) return 1;

        boolean[][] visited = new boolean[nr][nc];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        int ans = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < eightTong.length; j++) {
                    int newX = poll[0] + eightTong[j][0];
                    int newY = poll[1] + eightTong[j][1];

                    if (newX == nr-1 && newY == nc -1) return ans + 1;

                    if (newX >= 0 && newX < nr && newY >= 0 && newY < nc && !visited[newX][newY] && grid[newX][newY] == 0) {
                        queue.add(new int[]{newX,newY});
                        // 这里加到队列里面就一定需要是已经访问过了,不然还有可能被其他的点加入到队列里面
                        visited[newX][newY] = true;
                    }
                }
            }
            ans++;
        }

        return -1;
    }


    public static void main(String[] args) {

        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        System.out.println(new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
    }


}
