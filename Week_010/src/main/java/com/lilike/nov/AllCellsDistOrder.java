package com.lilike.nov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/matrix-cells-in-distance-order/
 * 距离顺序排列矩阵单元格
 *
 * @Author llk
 * @Date 2020/11/17 9:00
 * @Version 1.0
 */
public class AllCellsDistOrder {

    /**
     * 方法一 : 直接桶排序
     * <p>
     * [
     * [[0,1] ,[0,2]]
     * [[1,1], [1,2]]
     * ]
     *
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public int[][] allCellsDistOrder01(int R, int C, int r0, int c0) {

        int[][] arr = new int[R * C][];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                arr[i * C + j] = new int[]{i, j};
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Math.abs(o1[0] - r0) + Math.abs(o1[1] - c0) - (Math.abs(o2[0] - r0) + Math.abs(o2[1] - c0));
            }
        });

        return arr;
    }

    public static void main(String[] args) {

        /**
         *
         *   [
         *      [0,0],[0,1],
         *      [1,0],[1,1]
         *   ]
         *
         */
        new AllCellsDistOrder().allCellsDistOrder01(1, 2, 0, 0);

    }

}
