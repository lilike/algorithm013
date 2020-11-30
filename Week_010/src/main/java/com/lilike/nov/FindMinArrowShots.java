package com.lilike.nov;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author llk
 * @Date 2020/11/23 11:28
 * @Version 1.0
 */
public class FindMinArrowShots {

    /**
     * 根据尾巴进行排序,然后通过尾巴尽可能贯穿比较多的气球
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {

        if (points.length == 0) return 0;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int count = 1;
        int arror = points[0][1];
        for (int i = 1 ; i < points.length; i++) {
            if (arror >= points[i][0]) {
                continue;
            }
            count++;
            arror = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(new FindMinArrowShots().findMinArrowShots(points));


    }


}
