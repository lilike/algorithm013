package com.lilike.homework;

import java.util.Arrays;

/**
 * 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 *
 * @Author llk
 * @Date 2020/10/14 13:30
 * @Version 1.0
 */
public class SortedSquares {


    /**
     * 平方按照有序来进行排列,首先这个数组已经是排好序的了,我们要按照负数和非负数分别来对待
     * eg :
     * [ -3 , -2 , -1 , 1, 2 ,3 ]
     * <p>
     * 那么他们的平方依次是
     * [ 9, 4, 1, 1, 4, 9 ]
     * <p>
     * 可以看到负数的平方的初始值是按照 倒序排列的, 正数的平方是按照顺序排列的,
     * 关键就是找到负数和正数,然后用两个指针来指向,
     * 接下来就是归并排序的算法中的merge算法了
     *
     * @param A
     * @return
     */
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length == 0) return A;
        int pIdx = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                pIdx = i;
                break;
            }
        }

        int nIdx = pIdx == Integer.MAX_VALUE ? A.length - 1 : pIdx - 1;

        int[] temp = new int[A.length];

        int k = 0;
        while (nIdx >= 0 && pIdx <= A.length - 1) {
            if (Math.abs(A[nIdx]) <= Math.abs(A[pIdx])) {
                 temp[k++] = A[nIdx] * A[nIdx];
                 nIdx--;
            }else {
                temp[k++] = A[pIdx] * A[pIdx];
                pIdx++;
            }
        }

        while (nIdx >= 0) {
            temp[k++] = A[nIdx] * A[nIdx];
            nIdx--;
        }
        while (pIdx <= A.length - 1) {
            temp[k++] = A[pIdx] * A[pIdx];
            pIdx++;
        }

        return temp;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{-4,-1,0,3,10};

        new SortedSquares().sortedSquares(arr);

        System.out.println(Arrays.toString(arr));
    }

}
