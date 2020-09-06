package com.lilike.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 来自<<数据结构与算法之美>>
 * -- 初识动态规划
 * <p>
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 *
 * @Author llk
 * @Date 2020/8/31 9:45
 * @Version 1.0
 */
public class PackProblem {

    /**
     * 物品的个数
     */
    private int n = 5;
    /**
     * 背包能够承受的最大重量
     */
    private int w = 9;
    /**
     * 物品的重量
     */
    private int[] weight = {2, 2, 4, 3, 6};
    /**
     * 当前物品的总重量
     */
    private int maxW = 0;
    /**
     * 存放的结果
     */
    private List<List<Integer>> result = new ArrayList<>();


    public void solution4() {

        boolean[] memory = new boolean[w+1];

        // 首先初始化
        memory[0] = true;
        if (weight[0]<=w) memory[weight[0]] = true;

        for (int i = 1; i < n; i++) {
            // 把某个物品放入背包
            /** 假设这里从前面开始遍历,可能出现一种情况,就是不知道当前的重量是这次已经放了还是前面的没放
             *  比如[ false true false true  ... ]
             *  本次物品的重量是2
             *  你遍历到第四个的时候,不知道这个true是当前的重量2+2还是上一轮的4,这一轮没有放入
             * */
            for (int j = w - weight[i]; j >= 0; j--) {
                if (memory[j]) memory[weight[i] + j] = true;
            }
        }

        for (int i = w; i >= 0; i++) {
            if (memory[i]){
                maxW = i;
                break;
            }
        }
    }




    public void solution3() {

        boolean[][] memory = new boolean[n][w+1];

        memory[0][0] = true;
        if (weight[0] <= w) memory[0][weight[0]] = true;

        for (int i = 1; i < n; i++) {
            // 不放入某个物品
            for (int j = 0; j < w; j++) {
                if (memory[i-1][j]) memory[i][j] = true;
            }
            // 放入某个物品
            for (int j = 0; j <= w-weight[i]; j++) {
                if (memory[i-1][j])
                    memory[i][weight[i]+j] = true;
            }
        }

        // 找出最大的值
        for (int i = w; i >= 0; i--) {
            if (memory[n-1][i]) {
                maxW = i;
                break;
            }
        }
        for (int i = 0; i < memory.length; i++) {
            boolean[] bool = memory[i];
            System.out.println(Arrays.toString(bool));
        }

    }






    public void solution2() {
        // 由于回溯算法画出递归调用树之后,发现重复计算的内容太多了,因此进行改造,增加备忘录模式,如果调用参数是相同的,那么就不再递归调用
        boolean[][] memory = new boolean[n][w+1];
        backTrack(0,0,new Stack<>(),memory);
        for (int i = 0; i < memory.length; i++) {
            boolean[] bool = memory[i];
            System.out.println(Arrays.toString(bool));
        }

    }


    /**
     * @param i  考察第i物品的索引
     * @param cw 当前背包物品的重量
     */
    private void backTrack(int i, int cw, Stack<Integer> stack,boolean[][] memory) {
        if (cw == w) {
            result.add(new ArrayList<>(stack));
        }
        if (i == n) {
            if (cw >= maxW) {
                maxW = cw;
            }
            return;
        }
        if (memory[i][cw]) return;
        memory[i][cw] = true;
        // 不装第i个物品
        backTrack(i + 1, cw, stack,memory);
        // 装第i个物品
        if (cw + weight[i] <= w) {
            stack.push(weight[i]);
            backTrack(i+1, cw + weight[i], stack,memory);
            stack.pop();
        }
    }






    /**
     * 使用回溯法来解决
     */
    public void solution1() {
        // 优化,增加一个备忘录
        backTrack(0, 0, new Stack<Integer>());
    }



    /**
     * @param i  考察第i物品的索引
     * @param cw 当前背包物品的重量
     */
    private void backTrack(int i, int cw, Stack<Integer> stack) {
        if (cw == w) {
            result.add(new ArrayList<>(stack));
        }
        if (i == n) {
            if (cw >= maxW) {
                maxW = cw;
            }
            return;
        }
        // 不装第i个物品
        backTrack(i + 1, cw, stack);
        // 装第i个物品
        if (cw + weight[i] <= w) {
            stack.push(weight[i]);
            backTrack(i+1, cw + weight[i], stack);
            stack.pop();
        }
    }


    public static void main(String[] args) {

        PackProblem packProblem = new PackProblem();
        packProblem.solution3();
        System.out.println(packProblem.maxW);
        System.out.println(packProblem.result);

    }


}
