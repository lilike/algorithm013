package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @Author llk
 * @Date 2020/9/10 20:44
 * @Version 1.0
 */
public class ClimbStairs {

    /**
     * 递归加上剪枝
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        Map<Integer,Integer> cache = new HashMap<>();
        return dg(cache,n);
    }

    private int dg(Map<Integer,Integer> cache, int n) {

        // terminator
        if (n <= 2) return n;

        // process current logic
        Integer i = cache.get(n);
        if (cache.get(n) == null) {
            i = dg(cache, n - 1) + dg(cache, n - 2);
            cache.put(n,dg(cache, n - 1) + dg(cache, n - 2));
        }

        return i;

    }


    public static void main(String[] args) {


    }


}
