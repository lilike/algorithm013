package com.lilike.nov;

import com.lilike.util.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode-cn.com/problems/4sum-ii/
 *  四数相加 II
 * @Author llk
 * @Date 2020/11/27 9:28
 * @Version 1.0
 */
public class FourSumCount {

    /**
     * 时间复杂化度 O(n^2)
     *      首先将前面两个数组的和保存到链表里面,Key 就是他们的和 Value就是他们的和出现的次数
     *
     *      然后遍历后面两个数组,如果出现了 - c - d ,那么就加上来
     *
     *      这道题的第一想法是O(n^4)的时间复杂度,但是可以通过HashMap进行加速降维
     *
     *      以空间换时间
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int ans = 0;
        Map<Integer,Integer> cache = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                cache.put(a + b,cache.getOrDefault(a+b,0)+1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                if (cache.get(-c-d) != null) {
                    ans += cache.get(-c-d);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse("2013-04-26");
        Date date1 = DateUtil.formatDate("2013-04-26", "yyyy-MM-dd");
        Date date2 = DateUtil.formatDate("2015-04-26", "yyyy-MM-dd");

        System.out.println(date1.getTime());
        System.out.println(date2.getTime());

    }


}
