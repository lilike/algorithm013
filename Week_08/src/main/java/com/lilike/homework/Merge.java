package com.lilike.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *  合并数组
 *  https://leetcode-cn.com/problems/merge-intervals/
 * @Author llk
 * @Date 2020/9/18 22:22
 * @Version 1.0
 */
public class Merge {

    public int[][] merge(int[][] intervals) {

        // 首先按照左边的节点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0],R = intervals[i][1];

            if (result.size() == 0 || result.get(result.size()-1)[1] < L) {
                result.add(new int[]{L,R});
            }else {
                result.get(result.size()-1)[1] = result.get(result.size()-1)[1] < R ? R : result.get(result.size()-1)[1];
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

    public static void main(String[] args) {
        int[][] merge = new Merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int i = 0; i < merge.length; i++) {
            for (int j = 0; j < merge[i].length; j++) {
                System.out.print(merge[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
