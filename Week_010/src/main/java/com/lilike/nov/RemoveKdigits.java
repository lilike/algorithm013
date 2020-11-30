package com.lilike.nov;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 移掉K位数字
 * https://leetcode-cn.com/problems/remove-k-digits/
 *
 * @Author llk
 * @Date 2020/11/15 17:18
 * @Version 1.0
 */
public class RemoveKdigits {


    /**
     *  对于一个字符串,移掉 k 位数,然后让这个数最大
     *          比如 : 452 k = 1 那么就是移掉 5
     *
     *          有一个规律:
     *              对于位数相同的两个数字,左边的位数决定了大小
     *              452
     *              552 就是左边的位
     *
     *              同样
     *              如果是一个单调递增的
     *               1 2 3 4 5 6
     *               那么就只能移掉最后面的
     *
     *
     *          情况1:
     *              单调底增 移动最后面的
     *
     *          情况2:
     *              不是单调递增,那么就移动到左边 > 右边的数字
     *
     *
     *           采用贪心 + 单调栈
     *
     *
     *
     *
     */
    public String removeKdigits(String num, int k) {

        Deque<Integer> deque = new LinkedList<>();
        int n = num.length();
        for (int i = 0; i < n; i++) {
            int digst = Integer.valueOf(num.charAt(i)+"");
            while (k > 0 && !deque.isEmpty() && deque.peekLast() > digst ) {
                deque.removeLast();
                k--;
            }
            deque.addLast(digst);
        }

        for (int i = 0; i < k; i++) {
            deque.removeLast();
        }

        String ans = "";
        boolean flag = true;
        while (!deque.isEmpty()) {
            Integer integer = deque.removeFirst();
            if (integer == 0 && flag ) {
                continue;
            }
            flag = false;
            ans += integer;
        }

        return "".equals(ans) ? "0" : ans;
    }

    public static void main(String[] args) {
        String nums = "10";
        Integer k = 2;
        RemoveKdigits removeKdigits = new RemoveKdigits();
        String s = removeKdigits.removeKdigits(nums, k);
        System.out.println(s);

    }


}
