package com.lilike.homework;

/**
 * 按照奇偶排序数组
 * https://leetcode-cn.com/problems/sort-array-by-parity/
 *
 * @Author llk
 * @Date 2020/10/14 9:42
 * @Version 1.0
 */
public class SortArrayByParity {

    /**
     * 这个问题可以转换为根据某个数的余数进行从小到大的排序
     * 余数为0的放到前面,余数为1的放到后面
     * 归并排序 快速排序 冒泡都是可以的
     * 我就用归并把
     *
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        mergeSort(A, 0, A.length - 1);
        return A;
    }

    private void mergeSort(int[] a, int left, int right) {

        if (right <= left) return;

        int mid = left + (right - left) / 2;

        mergeSort(a, left, mid);
        mergeSort(a, mid + 1, right);
        merge(a, left, mid, right);
    }

    private void merge(int[] a, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = a[i] % 2 <= a[j] % 2 ? a[i++] : a[j++];
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];

        for (int l = 0; l < temp.length; l++) {
            a[left + l] = temp[l];
        }
    }


}
