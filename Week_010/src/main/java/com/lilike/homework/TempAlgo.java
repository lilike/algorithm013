package com.lilike.homework;

import java.util.*;

/**
 * @Author llk
 * @Date 2020/10/26 16:01
 * @Version 1.0
 */
public class TempAlgo {

    public static void main(String[] args) {
        int[] moneyPool = new int[]{20,30,30,20};
        int[] allocationPool = new int[]{10,5,10,30,45};

        List<int[]> solution = new TempAlgo().solution(moneyPool, allocationPool);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }


    }

    /**
     * 返回的结果是每个池子的分配情况
     * @param moneyPool
     * @param allocationPool
     * @return
     */
    public List<int[]> solution(int[] moneyPool, int[] allocationPool) {

        List<int[]> ans = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < moneyPool.length; i++) {
            int[] temp = new int[allocationPool.length];

            for (int j = current; j < allocationPool.length; j++) {
                if (moneyPool[i] > allocationPool[j]) {
                    temp[j] = allocationPool[j];
                    moneyPool[i] = moneyPool[i] - allocationPool[j];
                }else {
                    temp[j] = moneyPool[i];
                    current = j;
                    allocationPool[j] = allocationPool[j] - moneyPool[i];
                    break;
                }
            }
            ans.add(temp);
        }
        return ans;
    }




}
