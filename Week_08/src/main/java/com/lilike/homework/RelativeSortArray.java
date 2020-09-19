package com.lilike.homework;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 * @Author llk
 * @Date 2020/9/18 21:39
 * @Version 1.0
 */
public class RelativeSortArray {


    /**
     * 实现使用空间复杂度比较高的排序
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer,Integer> counter = new HashMap<>();
        Set set = new HashSet();
        for (int i : arr2) {
            set.add(i);
        }
        for (int i : arr1) {
            counter.put(i,counter.getOrDefault(i,0)+1);
        }

        List<Integer> collect = counter.keySet().stream().filter(x -> !set.contains(x)).sorted().collect(Collectors.toList());
        int index = 0;
        for (int j : arr2) {
            for (int i = 0; i < counter.get(j); i++) {
                arr1[index++] = j;
            }
        }

        for (Integer l : collect) {
            for (int i = 0; i < counter.get(l); i++) {
                arr1[index++] = l;
            }
        }

        return arr1;
    }


    public static void main(String[] args) {
        int[] arr1 = {2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31};
        int[] arr2 = {2,42,38,0,43,21};

        int[] ints = new RelativeSortArray().relativeSortArray(arr1, arr2);
        System.out.println(Arrays.toString(ints));


    }


}
