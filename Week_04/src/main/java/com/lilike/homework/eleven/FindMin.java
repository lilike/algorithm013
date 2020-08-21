package com.lilike.homework.eleven;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 *  寻找旋转排序数组中的最小值
 * @Author llk
 * @Date 2020/8/19 21:40
 * @Version 1.0
 */
public class FindMin {

    /**
     * 找到最小值
     *  首先把这个数组劈成两半
     *    首先最小值一定不在有序数组那一边
     *    其次,就是判断
     *      另外一边的left 是否 < right 如果是的话,就是最小值
     *
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right ) {
            if (nums[left] <= nums[right]) return nums[left];
            middle = left  + (right - left) /2;
            if (nums[left] <= nums[middle]) {
                left =  middle +1;
            }else {
                right = middle; // 中间值有可能是最小值
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindMin().findMin(new int[]{3,1,2}));


    }

}
