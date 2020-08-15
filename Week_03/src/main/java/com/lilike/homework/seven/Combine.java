package com.lilike.homework.seven;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/combinations/
 * 组合
 * @Author llk
 * @Date 2020/8/14 12:04
 * @Version 1.0
 */
public class Combine {


    List<List<Integer>> result = new ArrayList<>();
    /**
     * 这道题的大多数解法就是使用回溯法
     *      回溯法到达结果有很多步,使用递归,当前层处理当前层的事情,下一层处理下一步的事情
     *      直到到达终点,判断是否符合条件
     *      然后回到上一层,继续处理其他的可能性,这就是回溯
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {

        if (n == 0 || k == 0 || n < k) return result;
        _combile(n,k,1,new Stack<>());
        return result;
    }

    private void _combile(int n, int k, int i, Stack<Integer> stack) {

        if (stack.size() == k) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int j = i; j <= n; j++) {
            stack.push(j);
            _combile(n,k,j+1,stack);
            stack.pop();
        }
    }


    public static void main(String[] args) {
        Combine combine = new Combine();
        combine.combine(4,2);
        System.out.println(combine.result);
    }

}
