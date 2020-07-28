package com.lilike.homework;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * <p>
 * 盛水最多的容器
 *
 * @author lyric
 * @file MaxArea.java
 * @date 2020/7/28
 */
public class MaxArea {


    public static void main(String[] args) {

    }


    /**
     * 双指针法
     * <p>
     * 1. 一个指向头,一个指向尾巴
     * 2. 他们之间的底边可以通过 index 互减得到
     * 3. 使用一个临时的变量去记录最大的面积
     * 4. 得到一个面积后开始往中间移动,知道 两个指针遇到
     *
     * @param height
     * @return
     */
    public int solution1(int[] height) {

        int head = 0;
        int tail = height.length - 1;

        int maxArea = 0;
        while (head < tail) {

            int minHeight = Math.min(height[head], height[tail]);
            int area = (tail - head) * minHeight;

            maxArea = maxArea > area ? maxArea : area;

            if (minHeight == height[head]) {
                head++;
            }else {
                tail--;
            }

        }

        return maxArea;
    }


}
