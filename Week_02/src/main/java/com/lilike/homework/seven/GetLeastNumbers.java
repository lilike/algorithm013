package com.lilike.homework.seven;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 * https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 *
 * @author lyric
 * @file GetLeastNumbers.java
 * @date 2020/8/5
 */
public class GetLeastNumbers {

    public static void main(String[] args) {

        int[] nums = {0, 1, 1, 2, 4, 4, 1, 3, 3, 2};
        int k = 6;
        int[] leastNumbers = getLeastNumbers(nums, k);
        System.out.println(Arrays.toString(leastNumbers));
    }


    /**
     * 利用java里面大根堆,Java里面的优先队列就是小根堆
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {

        if (k == 0) {
            return new int[0];
        }


        Queue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.remove();
                queue.add(arr[i]);
            }
        }

        int[] result = new int[k];
        int index = 0;
        for (Integer integer : queue) {
            result[index++] = integer;
        }
        return result;
    }

}
