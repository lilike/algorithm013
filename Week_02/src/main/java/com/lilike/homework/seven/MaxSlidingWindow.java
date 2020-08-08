package com.lilike.homework.seven;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {

        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] peek = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(peek));

    }

    /**
     * 做堆排序,效率比较低
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {

        int index = 0;
        int[] result = new int[nums.length - k + 1];
        /** 用大根堆先存入前面k个数 */
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(o1,o2)->(o2-o1));
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        result[index++] = pq.peek();

        for (int i = k; i < nums.length; i++) {
            pq.remove(nums[i-k]);
            pq.add(nums[i]);
            result[index++] = pq.peek();
        }
        return result;
    }

}
