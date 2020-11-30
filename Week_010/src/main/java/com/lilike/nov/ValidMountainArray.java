package com.lilike.nov;

/**
 * 有效山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 *
 * @Author llk
 * @Date 2020/11/3 9:05
 * @Version 1.0
 */
public class ValidMountainArray {

    /**
     * 简单粗暴的是 O(n) 就是直接遍历一遍
     * <p>
     * 首先找到最大值下标
     * <p>
     * 然后判断下标前面是不是递增
     * 下标后面是不是递减
     * <p>
     * 就利用这个特性
     * 搞一个双指针
     * <p>
     * int i 指向开头
     * int j 指向结尾
     * <p>
     * 如果满足 a[i] < a[i+1] 那么就 i++
     * 如果满足 a[j] > a[j-1] 那么就 j--
     * <p>
     * 直到不满足
     * 看看 i == j
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        int i = 0, j = A.length - 1, n = A.length;
        while (i < n - 1 && A[i] < A[i + 1]) i++;
        while (j > 0 && A[j] < A[j - 1]) j--;
        return i == j && i > 0 && j < n - 1;
    }


}
