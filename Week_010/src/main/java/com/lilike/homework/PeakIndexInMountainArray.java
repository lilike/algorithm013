package com.lilike.homework;

/**
 * 山脉数组的峰顶索引
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 *
 * @Author llk
 * @Date 2020/10/14 13:55
 * @Version 1.0
 */
public class PeakIndexInMountainArray {

    /**
     * 用二分查找法应该是最快的
     * 关键在于如何找另外一边
     * <p>
     * 山峰的特点是:
     * arr[i-1] < arr[i] < arr[i+1]
     * <p>
     * 可以使用二分查找法
     *
     * @param arr
     * @return
     */
    public int peakIndexInMountainArray(int[] arr) {

        int left = 1, right = arr.length - 2;

        while (left <= right) {

            int mid = left + ((right - left ) >> 2);
            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
                return mid;
            }else if (arr[mid] > arr[mid-1] && arr[mid] < arr[mid+1]) {
                left = mid + 1;
            }else if (arr[mid] < arr[mid-1] && arr[mid] > arr[mid+1]) {
                right = mid-1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PeakIndexInMountainArray().peakIndexInMountainArray(new int[]{0,1,8,2,1,0}));
    }


}



