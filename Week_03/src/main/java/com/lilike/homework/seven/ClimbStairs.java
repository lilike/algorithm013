package com.lilike.homework.seven;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

/**
 *  https://leetcode-cn.com/problems/climbing-stairs/
 *   爬楼梯
 *
 * @Author llk
 * @Date 2020/8/10 8:54
 * @Version 1.0
 */
public class ClimbStairs {

    public static void main(String[] args) {

        System.out.println(Long.valueOf(1) == 1);


    }


     Map<Integer,Integer> cache = new HashMap<>();
    /**
     *  爬到 n 级楼梯的方法 = 爬到 n-1 级楼梯的方法 + 爬到 n-2 级楼梯的方法
     *  f(1) = 1 ;f(2) = 2
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }
        Integer n_1 = cache.get(n-1);
        Integer n_2=cache.get(n-2);
        if (n_2==null) {
            n_2 = climbStairs(n-2);
            cache.put(n-2,n_2);
        }
        if (n_1==null) {
            n_1 = climbStairs(n-1);
            cache.put(n-1,n_1);
        }
        return n_1 + n_2;
    }
}
