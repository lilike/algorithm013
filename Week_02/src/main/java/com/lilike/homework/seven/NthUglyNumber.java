package com.lilike.homework.seven;


import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/ugly-number-ii/
 * 计算丑数
 * <p>
 * 测试用例 n < 1690
 * 我们可以预计算出1690个
 * <p>
 * 思路1: 小根堆
 * 首先把 1,3,4,5放入到小根堆里面
 * <p>
 * 然后把 1 弹出 放到数组里面
 * <p>
 * 然后用弹出来的这个值分别去乘以堆里面的元素
 * <p>
 * 得到的结果如果堆里面不存在,就存入到堆里面,同时继续弹出来,继续乘以
 *
 * @author llk
 * @file NthUglyNumber.java
 * @date 2020/8/6
 */
public class NthUglyNumber {

    public static void main(String[] args) {
        Ugly ugly = new Ugly();
        System.out.println(Arrays.toString(ugly.nums));


    }

    public int nthUglyNumber(int n) {
        return new Ugly().nums[n-1].intValue();
    }


}

class Ugly {

    Long[] nums = new Long[1690];

    public Ugly() {
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();

        seen.add(1L);
        heap.add(1L);

        int[] uglys = new int[]{2, 3, 5};

        for (int i = 0; i < 1690; i++) {
            nums[i] = heap.poll();

            for (int ugly : uglys) {
                Long newUgly = ugly * nums[i];
                if (!seen.contains(newUgly)) {
                    seen.add(newUgly);
                    heap.add(newUgly);
                }

            }
        }


    }

}
