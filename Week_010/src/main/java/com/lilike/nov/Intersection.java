package com.lilike.nov;

import java.util.*;

/**
 * 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @Author llk
 * @Date 2020/11/2 9:23
 * @Version 1.0
 */
public class Intersection {

    /**
     * 1. 最简单的思路就是直接O(n)的时间复杂度,把一个放到hash表里面
     * 2. 对两个数组进行排序后,使用双指针,如果指针指向的数字相同,那么就同时后移,如果一个小,往前移动,时间复杂度O(nlogn)
     * 3. 对其中一个进行排序,然后以二分查找的方式进行
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            if (set1.contains(i) && !res.contains(i)) {
                res.add(i);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    /**
     * 双指针法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectionII(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }

        }
        int[] res = new int[set.size()];
        int index = 0;
        for (Integer integer : set) {
            res[index++] = integer;
        }

        return res;

    }

    /**
     * 使用二分查找法也是O(nlogn)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectionIII(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);

        for (int i : nums1) {
            if (binarySearch(i,nums2)) {
                set.add(i);
            }
        }

        int index = 0;
        int[] ans = new int[set.size()];
        for (Integer integer : set) {
            ans[index++] = integer;
        }

        return ans;
    }

    private boolean binarySearch(int i, int[] nums2) {

        int left = 0,right = nums2.length -1;

        while (left <= right) {

            int middle = left + (right - left) / 2;

            if (i < nums2[middle]) {
                right = middle - 1;
            }else if (i > nums2[middle]) {
                left = middle + 1;
            }else {
                return true;
            }
        }
        return false;
    }


}
