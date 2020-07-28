package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/***
 *  爬楼梯问题
 * @file Solution1.java
 * @author lyric
 * @date 2020/7/28
 */

public class ClimbStairs {

    private Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        ClimbStairs solution = new ClimbStairs();
        System.out.println(solution.solution1(10));
        System.out.println(solution.solution2(10));
        System.out.println(solution.solution3(10));
        System.out.println(solution.solution4(10));

    }


    /**
     * 不建立数组,只保存 f(n-1) 和 f(n-2)
     * @return
     */
    public int solution4(int n) {

        if (n <= 2) {
            return n;
        }

        int n_1 = 2;
        int n_2 = 1;
        int sn = 0;
        for (int i = 3; i <= n; i++) {
            sn = n_1 + n_2;
            n_2 = n_1;
            n_1 = sn;
        }
        return sn;

    }



    /**
     * 利用缓存的方式
     * @param n
     * @return
     */
    public int solution3(int n) {

        if (n <= 2) {
            return n;
        }

        Integer result = cache.get(n);
        if (result != null) {
            return result;
        }

        result = solution3(n-1) + solution3(n-2);
        cache.put(n,result);
        return result;
    }



    /**
     * 暴力递归的方法
     * @param n
     * @return
     */
    public int solution2(int n) {

        if(n <=2) {
            return n;
        }
        return solution2(n-1) + solution2(n-2);
    }





    /**
     * 本质上就是一个斐波那契数列
     * 利用一个数组,保存前面的结果,然后计算出fn
     * f(n) = f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public int solution1(int n) {
        if (n <= 2) {
            return n;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }
}
