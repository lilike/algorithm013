package com.lilike.homework;

/**
 * 寻找旋转排序数组中的最小值 II
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * @Author llk
 * @Date 2020/10/27 16:49
 * @Version 1.0
 */
public class FindMinII {


    /**
     *  画一个图就明白了
     *      由于数组被旋转过了,
     *      那么把数组分为两半
     *          左边是单调递增  右边也是单调递增
     *      但是左边和右边都可能有重复的数字
     *
     *      使用二分查找法
     *          left right middle
     *          如果 nums[middle] < nums[right] 那么最小值是在左边 right = middle
     *          如果 nums[middle] > nums[right] 那么最小值在右边 left = middle + 1
     *          如果 nums[middle] == nums[right] 那么最小值不知道是哪个,但是right可以左移一下,反正middle还是存在的
     *
     *
     *
     * @param nums
     * @return
     */

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0,right = nums.length - 1;

        if (nums[left] < nums[right]) return nums[left];

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            }else if (nums[middle] > nums[right]) {
                left = middle + 1;
            }else {
                right = right - 1;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {


    }


}
