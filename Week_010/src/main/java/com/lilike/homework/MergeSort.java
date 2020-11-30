package com.lilike.homework;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 *
 * @Author llk
 * @Date 2020/10/14 9:55
 * @Version 1.0
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {

        if (right <= left) return;

        int mid = left + (right - left) / 2;

        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {

        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        while (i <= mid) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int l = 0; l < temp.length; l++) {
            array[left+l] = temp[l];
        }

    }

    public static void main(String[] args) {

        int[] temp = new int[]{6,3,2,36,4,2,1};
        new MergeSort().sort(temp);
        System.out.println(Arrays.toString(temp));

    }

}
