package com.lilike.nov;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最接近原点的K个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * @Author llk
 * @Date 2020/11/9 15:03
 * @Version 1.0
 */
public class KClosest {


    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        return Arrays.copyOfRange(points,0,K);
    }

    /**
     * 优先队列
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        // 大根堆 最上面的是大的
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> - o1[0] * o1[0] - o1[1] * o1[1] + o2[0] * o2[0] + o2[1] * o2[1]);

        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > K) {
                pq.poll();
            }
        }

        int[][] ans = new int[K][2];
        while (K > 0) {
            ans[--K] = pq.poll();
        }

        return ans;
    }



    public static void main(String[] args) {
        int[][] points = new int[][] {
                {3,3},
                {5,-1},
                {-2,4}
        };

        KClosest closest = new KClosest();
        int[][] ints = closest.kClosest(points, 2);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }

    }



}
