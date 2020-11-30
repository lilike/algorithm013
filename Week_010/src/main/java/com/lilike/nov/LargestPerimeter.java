package com.lilike.nov;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * 三角形最大周长
 *
 * @Author llk
 * @Date 2020/11/29 17:58
 * @Version 1.0
 */
public class LargestPerimeter {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-1; i >= 2 ; i++) {
            if (A[i] < A[i-1] + A[i-2]) {
                return A[i] + A[i-1] + A[i-2];
            }
        }
        return 0;
    }
}
