package com.lilike.daily;

import java.util.*;

/***
 *  滑动窗口的最大值
 * https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @file MaxSlidingWindow.java
 * @author lyric
 * @date 2020/8/5
 */
public class MaxSlidingWindow {

    private int[] nums;

    private Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow3(nums, 3)));

    }

    /**
     * 双队列法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int index = 0;
        int[] result = new int[nums.length - k + 1];
        if (nums.length * k == 0) return new int[0];
        if (k== 1) return nums;

        int max_idx = 0;
        deque.addLast(0);
        // 需要得到前面k个值最大的索引,并且第一轮队列要放到deque里面
        for (int i = 1; i < k; i++) {
            while (deque.size() > 0 && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (nums[i] > nums[max_idx]) max_idx = i;
        }

        result[index++] = nums[max_idx];
        // 遍历
        for (int i = k; i < nums.length; i++) {
            while (deque.size() > 0 && deque.getFirst() <= i-k) {
                deque.removeFirst();
            }
            while (deque.size() > 0 && nums[i] > nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
            result[index++] = nums[deque.getFirst()];

        }


        return result;

    }


    /**
     * 如果上一轮滑动过程中得出来的最大值仍然还在这个窗口里面,直接用这个最大值和最新值进行比较就可以了,减少了时间复杂度
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }

        Integer max = null;
        Integer maxIndex = null;
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (maxIndex == null || maxIndex < i) {
                max = getMax2(nums, i, i + k, maxIndex);
            } else {
                max = max > result[i + k - 1] ? max : result[i + k - 1];
                maxIndex = max > result[i + k - 1] ? maxIndex : i + k - 1;
            }
            result[i] = max;

        }
        return result;
    }

    private int getMax2(int[] nums, int startIndex, int endIndex, Integer maxIndex) {
        int max = nums[startIndex];
        maxIndex = startIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return max;
    }


    /**
     * 思路1 : 通过队列的方式进行实现
     * 思路2 : 通过堆的方式进行实现
     * // 1. 一个方法是求这个滑动窗口内的最大值 getMax(nums,startIndex,endIndex) 但是如果每次都全部遍历似乎有浪费的地方
     * // 如果上一次的最大值的索引仍然在这个框内,就直接拿这个值和最新值进行比较
     * // 如果上一次的最大值的索引不在这个框里面,重新进行比较
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int startIndex = i;
            int endIndex = i + k;
            result[i] = getMax(nums, startIndex, endIndex);
        }
        return result;
    }

    private int getMax(int[] nums, int startIndex, int endIndex) {
        int max = nums[startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    private int getMax2(int[] nums, int startIndex, int endIndex) {
        int max = nums[startIndex];
        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

}


