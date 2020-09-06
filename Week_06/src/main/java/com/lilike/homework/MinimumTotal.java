package com.lilike.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三角形最小路径之和
 * https://leetcode-cn.com/problems/triangle/discuss/38735/Python-easy-to-understand-solutions-(top-down-bottom-up)/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 * @Author llk
 * @Date 2020/9/2 13:06
 * @Version 1.0
 */
public class MinimumTotal {

    /**
     * 最小和
     * @param triangle 三角形
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) return 0;

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                int current = triangle.get(i).get(j);

                // 笔直上面的index
                int x = i-1;
                int y = j;
                int bz = y > triangle.get(x).size() - 1 ? Integer.MAX_VALUE : triangle.get(x).get(y);

                // 斜方向
                x = i-1;
                y = j-1;
                int xiexiang =  y < 0 || y > triangle.get(x).size() - 1 ? Integer.MAX_VALUE : triangle.get(x).get(y);

                list.set(j,current + Math.min(bz,xiexiang));
            }
        }


        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
            if (triangle.get(triangle.size()-1).get(i) < res) res = triangle.get(triangle.size()-1).get(i);
        }


        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        int[][] param = {{2},{3,4},{6,5,7},{4,1,8,3}};
        for (int[] ints : param) {
            List<Integer> r = new ArrayList<>();
            for (int anInt : ints) {
                r.add(anInt);
            }
            list.add(r);
        }

        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println(new MinimumTotal().minimumTotal(list));

        System.out.println();
        System.out.println();
        for (List<Integer> integers : list) {
            for (Integer integer : integers) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

}
