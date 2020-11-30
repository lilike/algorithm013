package com.lilike.homework;

/**
 * 搜索旋转排序数组 II
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 *
 * @Author llk
 * @Date 2020/10/22 16:31
 * @Version 1.0
 */
public class SearchII {

    /**
     * 和 搜索旋转排序数组I的区别就是可能有重复数据
     * 继续使用二分查找法:
     * 第一种情况:  1011122    nums[start] == nums[mid] 这种情况, 把 start 往前面挪一下
     * 第二种情况:  456 7 123  num[start] < nums[mid] 左边是有序的
     * 第三种情况: 678 1 234   num[start] > nums[mid] 右边是有序的
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        if (nums.length == 1) return nums[0] == target ? true : false;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[nums.length - 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new SearchII().search(new int[]{3,1},1));
    }

}
