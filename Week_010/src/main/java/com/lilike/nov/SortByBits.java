package com.lilike.nov;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  根据二进制下面的1进行数目排序
 *  https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * @Author llk
 * @Date 2020/11/6 8:46
 * @Version 1.0
 */
public class SortByBits {

    public int[] sortByBits(int[] arr) {

        List<Integer> list = Arrays.stream(arr).boxed().sorted((x,y) -> {
            if (getBitCount(x).equals(getBitCount(y))) {
                return x - y;
            }else{
                return getBitCount(x) - getBitCount(y);
            }
        }).collect(Collectors.toList());
        System.out.println(list);
        int[] arrNew = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arrNew[i] = list.get(i);
        }
        return arrNew;
    }

    private Integer getBitCount(Integer number) {
        int count = 0;
        while (number > 0) {
            if ((number & 1) == 1) {
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static void main(String[] args) {

        SortByBits sortByBits = new SortByBits();
        int[] arr = {1024,512,256,128,64,32,16,8,4,2,1};
        for (int i : arr) {
            System.out.println(i +"\t" + sortByBits.getBitCount(i));
        }

    }

}
