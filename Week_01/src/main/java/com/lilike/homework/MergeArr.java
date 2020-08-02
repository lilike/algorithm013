package com.lilike.homework;

import java.util.Arrays;

/***
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *  合并数组
 *
 * @file MergeArr.java
 * @author lyric
 * @date 2020/8/2
 */
public class MergeArr {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;

        int[] nums2 = {2,5,6};
        int n = 3;

        MergeArr mergeArr = new MergeArr();
        mergeArr.merge3(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));


    }


    /**
     * 双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {

        int first = 0;
        int second = 0;
        int index = 0;
        int[] newArr = new int[nums1.length];

        while (first < m && second < n) {
            if (nums1[first] < nums2[second]) {
                newArr[index++] = nums1[first++];
            }else {
                newArr[index++] = nums2[second++];
            }
        }

        if (first < m) {
            for (int i = first; i < m; i++) {
                newArr[index++] = nums1[i];
            }
        }else if (second < n) {
            for (int i = second; i < n; i++) {
                newArr[index++] = nums2[i];
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = newArr[i];
        }



    }

    /**
     * 开新数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int j = 0;
        for (int i = m; i < m+n; i++) {
            nums1[i] = nums2[j++];
        }

        // 排序就可以
        Arrays.sort(nums1);

    }




    /*
        合并两个数组
        方法1: 写一个方法,用来插入一个数字到nums1数组当中去,然后迭代nums2,一次插入
        方法2: 开一个新数组,长度是nums1的长度,然后遍历nums1和nums2,比较大小依次插入
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; i++) {
            insertIntoNums1(nums1,m+i,nums2[i]);
        }

    }

    private void insertIntoNums1(int[] nums1, int i, int num) {

        int index = i;
        for (int j = 0; j < i; j++) {
            if (nums1[j] > num){
                index = j;
                break;
            }
        }

        // 说明要把num放到index的索引上,index -- > i move --> 1 位
        for (int j = i; j > index; j--) {
            nums1[j] = nums1[j-1];
        }
        nums1[index] = num;

    }


}
