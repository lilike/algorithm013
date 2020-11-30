package com.lilike.homework;

/**
 * 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @Author llk
 * @Date 2020/10/22 15:30
 * @Version 1.0
 */
public class Search {

    /**
     * 前置条件是 数组一定被循环了.
     * <p>
     * 这个题目依然可以用二分查找法来实现
     * <p>
     * [ 4, 5, 6, 7, 0, 1, 2]
     * <p>
     * 思路: 首先找到那个旋转的点,比如是 7 特点就是  < 7 >
     * <p>
     * 然后知道了左边 和 右边的第一个数字
     * <p>
     * 然后根据这个数字进行比较
     * <p>
     * 然后使用二分查找法.
     * <p>
     * 这种时间复杂度是 O(n)
     * <p>
     * 但是我记得这个题目是可以直接用二分查找法的.
     * <p>
     * 时间复杂度是O(logn)
     * <p>
     * 关键是如何取左右边的问题?
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        // [5,6,7,8,0,2,3]
        // 把一个数组分为两半之后,总会有一半是有序的
        // 首先判断哪一边是有序的,并且target在这个范围内的话,就去这个范围里面查询,否则就是去另外一边进行查询.
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 2);
            if (nums[mid] == target) return mid;
            if (nums[0] <= nums[mid]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[nums.length-1] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {

        System.out.println(new Search().search(new int[]{1, 3}, 3));


    }


}
