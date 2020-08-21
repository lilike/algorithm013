package com.lilike.homework.eleven;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @Author llk
 * @Date 2020/8/19 20:54
 * @Version 1.0
 */
public class Search {

    /**
     * 旋转数组依然是可以采用二分查找法来进行的
     * 因为数组一开始是一个有序的,
     *  然后把前面的一段放到后面去了,那么如果我们把这个数组砍成两半
     *  那么一定是有一遍是有序的
     *  要么是左边是有序的,要么就是右边是有序的
     *  判断的依据就是 nums[left] < nums[middle] || nums[middle] < nums[right]
     *  然后判断这个数组是否在这个有序的这一段中间,
     *      如果是,就进行相应的操作,如果不是,就是在另外一边
     *
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {
            middle = left + (right-left)/2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[left] <= nums[middle]){
                // 左边是有序的
                if (target >= nums[left] && target < nums[middle]) {
                    right = middle - 1;
                }else {
                    left = middle + 1;
                }

            }else {
                // 右边是有序的
                if (target > nums[middle] && target <= nums[right]) {
                    left = middle + 1;
                }else {
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Search().search(new int[]{3,1},1));
    }

}
