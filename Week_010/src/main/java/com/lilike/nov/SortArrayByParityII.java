package com.lilike.nov;

/**
 * @Author llk
 * @Date 2020/11/12 8:45
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {

        if (A == null || A.length == 0) return A;

        int i = 0, j = 1, n = A.length;

        while (i < n && j < n) {

            while (i < n && A[i] % 2 == 0) {
                i += 2;
            }

            while (j < n && A[j] %2 == 1) {
                j += 2;
            }

            if ( i < n && j < n) {

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

            }
        }
        return A;
    }


}
