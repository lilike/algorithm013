package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/10/14 11:41
 * @Version 1.0
 */
public class SortArrayByParityII {


    public int[] sortArrayByParityII(int[] A) {

        if (A == null || A.length == 0) return A;
        /** 因为题目提到了,奇数和偶数相同,所以长度一定>2 */
        int i = 0, j = 1, n = A.length;

        while (i < n && j < n) {

            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }

            while (j < n && A[j] % 2 == 1) {
                j += 2;
            }

            if (i < n && j < n) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }


    public static void main(String[] args) {

    }


}
