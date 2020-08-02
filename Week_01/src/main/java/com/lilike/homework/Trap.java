package com.lilike.homework;

/**
 * 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author lyric
 * @file Trap.java
 * @date 2020/8/2
 */
public class Trap {

    public static void main(String[] args) {

        Trap trap = new Trap();
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};

        int trap1 = trap.trap(nums);

        System.out.println(trap1);
    }


    /**
     * 按照列来求
     * 遍历这个数组
     * 取出一个值
     * 获取两边的最大值
     * 如果有一个是0就没有接到雨水
     * 如果都不是0,那么取两边最小值 - 当前值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;

        for (int i = 1; i < height.length-1; i++) {
            int leftMax = getLeftMax(height, i);
            int rightMax = getRightMax(height,i);

            int min = Math.min(leftMax,rightMax);

            if (min == 0) {
                continue;
            }

            int temp = min - height[i];
            if (temp <= 0) {
                continue;
            }
            sum += temp;

        }

        return sum;
    }

    private int getRightMax(int[] height, int index) {
        if (index == height.length -1) {
            return 0;
        }
        int max = height[index];
        for (int i = index+1; i < height.length; i++) {
            if (max < height[i]) {
                max = height[i];
            }
        }
        return max;
    }

    private int getLeftMax(int[] height, int index) {
        if (index == 0) {
            return 0;
        }
        int max = height[0];

        for (int i = 0; i < index; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

}
