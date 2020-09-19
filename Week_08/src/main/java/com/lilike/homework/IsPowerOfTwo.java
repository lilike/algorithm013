package com.lilike.homework;

/**
 *  2的幂
 *  https://leetcode-cn.com/problems/power-of-two/
 * @Author llk
 * @Date 2020/9/15 17:17
 * @Version 1.0
 */
public class IsPowerOfTwo {

    /**
     *  判断一个数是否是2的幂次方
     *  首先保留这个数的最后一个1
     *   x & (-x) 就是保留了这个数二进制位的最后一个1
     *
     *   关于 -x 的表示方式 是 ~x+1
     *
     *   所以发现 x & (-x) 就可以得到这个数二进制位的最后一个1
     *
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {

        // 由于0不是正数也不是负数
        if ( n == 0 )return false;
        long ln = Long.valueOf(n);
        if ( (ln & -ln) == ln) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {

    }

}
