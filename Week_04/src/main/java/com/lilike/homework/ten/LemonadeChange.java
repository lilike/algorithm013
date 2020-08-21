package com.lilike.homework.ten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/lemonade-change/description/
 * 柃檬水找零
 *
 * @Author llk
 * @Date 2020/8/18 22:19
 * @Version 1.0
 */
public class LemonadeChange {


    /**
     * 因为面值只有 5 10 20 所以记录 5 和 10 的面值数量即可
     * @param bills
     * @return
     */
    public boolean lemonadeChange1(int[] bills) {

        int five = 0, ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i]==10) {
                if (five > 0) {
                    five--;
                    ten++;
                }else {
                    return false;
                }
            }else {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }else if (five > 3) {
                    five-=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }



        /**
         * 贪心算法,每次都找给用户最大的零钱即可
         * 这个算法直接超时了.
         * @param bills
         * @return
         */
    public boolean lemonadeChange(int[] bills) {

        PriorityQueue<Integer> money = new PriorityQueue<>((o1, o2) -> o2 - o1);

        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < bills.length; i++) {

            int old = bills[i];
            if (old > 5) {
                if (money.peek() == null) return false; // 没有零钱了

                while (old != 5 && money.size() > 0) {
                    Integer m = money.poll();
                    if (m + 5 > old) {
                        temp.add(m);
                        continue;
                    } else {
                        old = old - m;
                    }
                }
                if (old > 5) return false;
            }

            money.add(bills[i]);
            if (temp.size() > 0) {
                money.addAll(temp);
                temp.clear();
            }

        }
        return true;
    }


    public static void main(String[] args) {

        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,20,5,20,5,5,5,10,20,5,5,10,5,10,5,10,5,5,5,20,10,5,5,5,5,5,5,20,5,10,10,20,5,20,5,5,10,5,20,5,5,5,10,5,10,10,10,10,10,5,20,5,20,20,5,5,5,5,5,5,5,20,10,5,5,5,20,5,5,5,20,5,5,5,5,20,20,5,5,20,20,5,5,5,20,5,5,10,10,10,5,20,20,5,20,5,5,10,10,20,20,5,5,20,10,5,5,10,20,5,20,5,5,5,20,5,20,5,5,5,5,5,5,5,20,20,10,5,5,5,5,20,5,20,20,5,10,10,20,20,20,5,5,5,5,10,10,5,5,20,20,10,5,5,10,20,5,5,5,5,5,20,10,20,5,5,5,10,5,5,5,10,5,5,10,10,20,5,5,10,10,10,10,5,5,5,5,20,10,5,20,10,5,5,5,20,10,5,5,5,5,5,5,5,10,10,10,5,20,5,5,5,5,20,5,10,10,20,5,5,5,5,10,5,5,5,10,10,5,5,5,5,5,10,5,5,10,20,20,5,10,5,5,5,10,5,5,5,20,5,5,5,20,5,5,5,5,5,10,10,5,5,5,5,5,10,10,5,5,5,20,5,5,5,5,5,5,5,5,10,5,10,5,20,5,20,20,5,20,5,10,20,5,5,5,5,5,5,5,10,5,20,5,10,5,10,5,5,5,5,20,10,5,20,10,5,10,5,5,20,10,20,10,5,5,5,5,5,5,20,5,10,10,20,5,5,10,5,5,5,5,20,20,5,10,5,5,20,5,10,5,20,5,5,5,20,5,5,5,10,5,10,20,20,10,5,20,20,10,10,20,5,20,5,5,10,5,5,10,5,5,20,5,5,5,5,5,5,5,5,5,5,20,5,5,5,20,5,10,5,10,10,20,5,5,5,20,5,5,20,5,20,5,5,5,10,5,5,10,20,5,5,10,10,5,5,5,20,20,20,5,5,5,20,10,20,20,10,5,5,5,5,10,5,5,5,5,5,10,5,5,5,5,5,5,5,20,5,5,10,20,5,5,5,5,10,5,5,5,20,5,5,20,20,10,20,10,5,5,5,5,20,20,10,10,20,20,5,5,5,5,5,5,5,5,10,5,5,20,5,5,5,20,5,5,10,10,5,5,5,5,10,5,5,5,5,10,5,10,5,20,5,5,5,10,5,20,5,20,5,5,5,5,10,5,20,5,10,5,5,5,10,5,10,10,5,5,10,20,5,5,5,10,5,5,5,5,10,10,5,10,10,20,5,10,5,5,5,5,5,10,20,20,5,5,5,5,10,10,5,20,5,5,10,5,20,5,5,5,5,5,10,10,5,5,5,5,10,5,5,20,5,5,5,5,5,5,20,5,5,10,5,5,5,10,5,5,5,5,20,5,5,20,10,20,20,20,5,10,5,5,5,5,20,5,5,10,10,10,5,5,20,5,5,20,20,5,5,5,20,5,5,5,5,20,5,5,10,5,20,10,5,5,5,20,5,10,10,5,5,5,20,5,5,5,5,5,5,10,5,5,10,10,5,20,10,20,5,5,5,5,5,20,5,5,20,5,5,5,5,20,5,5,20,10,20,10,5,20,5,5,5,5,5,5,5,5,20,5,20,5,10,5,10,5,5,5,10,5,10,5,5,5,5,20,10,10,5,10,5,5,5,20,20,5,5,5,5,5,20,5,5,10,20,5,5,5,5,5,5,5,5,5,5,10,20,5,10,5,5,5,10,5,5,5,5,10,10,10,10,5,10,5,20,5,5,20,10,5,5,5,5,5,5,5,5,5,20,5,5,10,10,5,10,5,10,5,5,20,20,5,10,5,10,5,5,20,10,5,20,5,20,20,5,10,10,10,10,20,10,5,5,5,20,5,10,20,5,5,5,5,10,5,20,20,5,20,5,10,20,5,5,5,5,5,5,10,5,5,5,20,5,5,5,5,10,5,20,20,20,5,5,20,20,5,5,5,20,5,5,20,5,5,5,5,5,5,5,5,10,20,5,5,10,10,5,10,10,20,5,5,5,5,20,20,5,10,10,5,5,5,5,5,20,5,5,5,10,20,5,5,10,20,5,20,5,20,10,5,20,20,5,20,5,5,10,20,5,5,20,10,5,10,5,5,5,5,5,5,5,10,10,20,10,20,10,5,5,20,5,10,5,10,10,5,5,5,5,5,5,5,20,10,20,20,10,10,20,5,5,20,5,20,5,10,5,10,20,20,10,20,5,5,5,5,5,5,5,20,5,10,10,10,5,20,20,10,5,20,5,5,5,5,10,10,5,5,5,20,20,5,10,5,5,5,10,5,10,20,20,5,20,5,5,5,5,20,20,5,20,10,20,5,5,5,20,5,5,20,10,5,10,10,10,5,5,5,5,5,5,10,5,5,20,20,5,10,5,5,5,5,5,20,5,5,10,5,5,5,5,10,10,10,10,5,20,5,5,20,10,5,5,20,5,5,5,5,5,10,5,5,5,5,10,5,5,5,10,5,5,5,5,20,10,5,5,5,5,5,20,5,20,5,5,5,5,5,10,5,5,20,20,5,5,5,5,10,20,10,5,10,10,5,10,5,20,5,5,20,20,5,10,5,5,5,5,20,10,5,5,5,20,5,10,5,5,10,5,5,10,5,5,5,10,5,5,5,20,5,10,5,5,5,5,5,20,20,5,5,5,5,5,5,20,5,5,5,5,5,20,5,5,5,10,10,10,5,10,20,5,20,20,5,5,5,5,10,5,5,5,10,10,5,5,5,10,5,20,5,5,5,5,5,5,5,5,5,10,5,5,5,10,5,5,10,5,5,5,5,5,5,20,5,5,5,5,5,10,5,5,5,5,10,5,10,5,20,20,20,10,20,5,5,5,5,5,5,5,5,20,20,20,5,10,20,20,20,20,5,5,20,10,20,5,5,5,5,5,5,5,5,20,5,5,5,10,10,5,5,20,20,5,5,5,5,5,5,20,5,5,5,20,5,5,5,5,10,20,5,20,20,20,10,5,5,5,5,5,5,5,20,20,10,5,10,5,5,5,5,5,10,5,20,5,10,5,20,20,5,5,20,5,20,5,10,5,5,5,20,20,10,5,10,10,20,5,5,5,5,5,5,10,5,20,5,5,5,5,20,5,5,5,5,20,10,5,5,20,10,5,5,5,5,10,10,5,5,5,5,20,5,5,5,10,5,5,10,5,5,5,5,5,5,20,10,5,20,5,10,5,5,5,5,5,5,5,5,10,5,5,20,5,5,5,20,20,5,20,10,10,5,5,10,10,5,5,5,20,5,5,5,5,10,5,5,5,5,5,20,10,5,20,5,5,5,5,5,20,5,5,5,5,5,5,5,5,5,5,20,5,5,5,5,10,10,10,5,5,5,10,20,5,5,5,5,10,20,20,20,5,10,10,20,20,5,5,5,5,5,5,5,5,10,20,5,5,5,5,10,10,5,20,5,5,5,5,5,20,5,10,5,5,5,20,5,5,5,5,20,5,10,20,5,5,5,5,5,5,10,5,5,5,10,20,5,10,10,5,5,10,5,10,10,5,5,5,5,10,5,5,5,5,20,5,10,5,5,5,5,5,10,20,5,10,10,20,5,10,20,20,20,5,5,20,5,20,10,20,10,5,10,5,5,10,5,5,5,5,5,5,10,10,5,5,5,10,5,20,20,5,5,20,5,10,5,5,5,10,20,5,10,5,5,5,5,20,5,5,5,5,5,5,10,5,5,10,5,5,5,20,20,5,5,5,5,5,5,5,5,5,5,20,10,10,20,10,20,20,5,5,10,10,5,5,10,5,20,5,20,10,5,10,5,5,20,5,5,5,5,5,5,10,10,5,20,10,5,20,20,5,20,5,10,5,20,5,10,5,5,5,5,5,5,5,20,10,20,5,5,5,5,20,10,5,5,5,10,5,5,5,20,5,5,5,5,10,5,5,10,5,20,10,5,10,5,5,5,5,5,10,10,20,5,5,20,5,5,20,5,5,5,10,20,5,5,5,5,5,5,10,10,5,10,5,5,5,5,20,10,5,20,5,10,5,20,20,10,5,5,5,5,20,5,10,5,20,5,5,5,5,5,10,5,20,10,20,20,10,5,10,10,5,20,20,5,20,20,5,5,5,20,5,10,5,5,5,20,5,5,5,5,5,5,10,20,10,5,5,5,5,20,5,5,5,5,10,5,20,5,5,10,5,10,10,5,5,5,5,10,5,5,5,5,5,10,5,5,10,5,5,20,20,10,5,10,20,10,10,5,20,5,20,10,5,5,10,5,5,5,20,5,20,5,5,5,5,5,5,5,5,5,5,20,20,10,10,5,5,20,5,10,5,10,5,5,20,20,20,20,10,20,5,5,5,10,5,10,5,5,5,20,5,10,20,20,5,5,10,5,5,20,5,5,10,5,5,5,5,5,5,5,10,5,10,10,20,5,5,10,10,10,10,20,20,10,10,5,5,5,5,10,10,5,10,5,10,5,5,10,5,20,20,5,10,5,5,5,5,5,5,10,10,10,5,5,5,5,5,5,20,5,5,10,5,20,5,5,20,20,5,20,20,5,5,20,20,5,5,5,10,10,5,5,5,5,5,5,5,5,20,5,5,20,10,5,20,10,20,5,20,10,5,5,5,5,10,20,10,20,10,5,5,5,20,5,20,20,5,5,20,5,5,5,5,5,10,5,5,5,5,10,20,10,5,5,10,20,10,10,10,5,5,5,10,20,20,10,5,5,20,5,5,5,10,10,5,5,10,5,20,20,5,5,5,10,5,5,5,20,5,10,5,10,5,5,5,10,20,5,5,10,10,10,20,5,20,5,20,5,5,10,5,5,10,5,5,5,5,10,5,5,20,10,5,5,10,5,5,20,5,5,20,20,10,5,5,10,5,20,20,5,5,20,20,5,10,10,20,5,20,5,5,10,5,10,5,5,5,5,5,5,5,5,5,5,5,5,20,20,10,5,10,20,20,5,20,10,10,5,5,20,10,10,5,5,5,10,10,5,20,10,20,20,10,20,10,10,5,20,5,5,20,10,5,5,20,5,5,10,10,5,20,5,10,5,20,5,5,5,5,20,5,20,20,10,20,20,5,5,5,5,5,20,5,5,10,5,5,10,20,5,5,10,10,20,5,5,5,20,5,5,20,10,5,5,5,20,5,5,10,10,10,5,10,5,10,5,5,20,5,5,5,5,10,5,5,10,5,20,5,5,5,10,20,5,10,20,20,10,10,10,20,5,5,5,5,5,20,10,5,5,5,5,5,5,20,20,5,5,5,5,5,10,5,20,5,20,20,5,20,20,5,10,5,5,10,5,5,10,5,5,10,20,5,5,10,10,5,5,5,5,5,5,20,5,5,20,10,5,5,5,5,5,20,10,5,5,5,5,5,5,10,5,20,5,20,5,20,5,5,5,5,5,5,5,10,20,5,5,10,5,5,5,5,20,5,5,10,10,5,5,5,10,5,5,20,5,5,5,5,5,5,20,5,5,10,5,5,5,5,20,5,20,5,5,20,5,5,10,20,5,20,5,5,20,5,5,10,10,10,20,5,5,10,5,20,5,5,10,20,5,5,10,5,10,5,5,20,10,20,5,5,20,20,5,20,10,10,5,5,10,5,5,5,5,20,5,5,5,5,10,5,20,20,5,5,20,20,5,20,5,5,5,5,20,5,10,10,5,5,10,5,5,5,5,10,20,10,5,5,5,5,5,5,20,5,10,5,5,5,5,20,20,5,10,5,5,10,10,5,10,5,10,5,5,5,20,20,5,5,5,10,5,20,10,5,10,5,5,5,5,10,5,5,5,5,5,5,5,5,20,5,10,10,20,5,5,5,20,5,5,5,5,5,20,5,20,5,5,20,10,5,20,5,5,10,10,20,20,5,5,10,20,20,5,10,20,10,20,5,5,5,5,20,5,20,5,5,20,20,10,20,5,5,5,10,20,5,5,5,20,5,5,5,5,5,5,20,5,5,5,20,5,5,5,20,20,5,5,5,20,5,20,5,10,10,5,10,5,10,10,20,5,20,20,5,10,5,5,5,5,5,10,5,10,5,5,5,5,5,5,5,20,5,5,5,5,5,20,5,5,5,5,5,20,20,5,5,5,5,5,20,20,5,5,20,5,5,5,5,10,5,5,10,20,5,5,5,20,20,10,5,5,20,5,5,5,5,5,5,5,5,5,5,20,5,5,5,20,20,20,20,20,10,5,5,5,20,5,10,10,10,5,10,10,10,5,5,20,20,5,5,5,5,10,5,5,5,20,10,5,5,5,5,5,10,20,10,20,5,5,5,10,5,20,5,10,10,5,20,10,20,5,5,5,5,5,10,20,5,5,5,5,5,5,10,20,10,20,20,5,5,10,5,5,5,20,5,20,10,10,5,5,5,5,5,20,5,5,5,5,5,5,20,5,20,5,20,5,5,5,20,5,5,5,5,20,20,20,5,5,5,10,5,10,20,5,20,5,5,5,5,10,5,5,20,5,5,5,10,5,5,5,20,10,20,5,5,20,5,10,5,5,5,10,5,5,5,10,20,20,10,5,5,5,5,20,5,20,5,5,5,20,5,5,5,5,20,5,5,20,5,5,5,5,20,20,5,10,5,5,5,5,5,5,5,5,5,20,5,10,5,20,20,20,20,10,5,10,5,20,5,5,20,10,20,5,5,5,20,5,5,5,5,10,5,5,20,5,10,5,5,10,5,20,5,10,5,20,20,5,5,20,20,5,20,5,5,5,20,5,20,5,5,5,10,5,5,5,5,5,20,5,5,5,5,5,5,10,20,20,5,5,20,20,10,5,20,5,10,20,5,5,5,5,5,5,5,5,10,20,5,5,5,5,10,5,20,5,10,5,5,20,10,5,5,5,5,5,5,5,5,5,10,5,5,5,20,5,20,10,10,10,5,5,5,5,10,10,10,5,10,5,20,20,20,20,5,5,5,20,5,5,5,20,10,5,20,5,10,20,5,5,10,20,20,10,5,5,5,5,5,5,5,5,20,20,5,5,5,20,10,10,10,5,5,5,20,5,10,5,10,20,5,10,5,5,5,20,5,5,5,5,5,5,5,20,5,10,5,5,5,10,5,20,20,5,5,5,10,5,5,5,5,10,5,5,20,5,5,10,10,5,20,10,20,10,10,5,5,5,5,5,10,5,5,5,10,5,5,20,10,20,20,20,10,20,5,5,5,5,5,5,20,5,20,20,5,5,10,10,5,5,20,5,5,5,5,20,10,20,5,5,5,5,10,5,5,5,5,20,5,10,5,5,10,5,5,5,5,5,5,5,5,5,5,10,5,10,20,10,5,20,20,5,5,20,20,10,5,5,10,5,5,10,20,20,5,20,20,10,10,5,5,5,20,20,5,5,20,20,5,5,10,5,20,5,5,20,20,10,20,5,20,5,20,20,5,5,10,10,10,10,5,5,5,10,10,10,20,5,5,5,5,5,5,5,10,10,10,5,20,5,10,10,20,5,5,5,20,5,5,5,5,5,10,5,10,5,10,5,20,20,20,5,10,5,5,10,5,5,5,20,5,10,5,10,5,5,10,5,20,5,5,10,20,5,20,5,5,20,20,5,5,20,5,5,5,5,5,5,10,10,5,10,10,5,5,5,5,20,5,5,5,5,5,20,5,5,5,5,20,10,10,5,5,5,10,5,5,20,5,5,5,5,5,5,5,20,20,20,5,20,5,5,5,10,5,5,5,5,5,10,20,5,10,10,10,5,5,20,20,5,10,5,5,5,20,20,10,5,5,5,5,20,20,5,5,5,20,5,10,5,5,5,5,5,5,10,5,5,5,5,20,10,10,5,5,5,5,5,10,5,5,5,5,5,5,5,5,20,10,5,20,5,10,5,20,5,5,5,5,20,5,5,5,5,20,20,5,10,5,20,5,20,5,20,20,5,20,5,5,5,5,10,20,5,20,5,5,5,20,10,10,5,5,5,5,5,10,5,10,5,5,5,5,20,5,5,20,20,5,5,10,5,20,10,5,10,10,10,5,20,20,5,5,5,5,5,5,20,5,5,5,20,5,10,5,5,5,5,5,5,5,10,5,10,10,5,5,5,5,5,20,5,10,5,5,5,5,20,10,5,5,5,20,20,5,10,5,10,5,5,5,5,5,5,20,5,10,10,20,20,5,20,10,20,20,5,5,10,5,20,5,5,10,10,20,5,5,5,5,5,5,5,5,5,20,5,5,5,5,20,20,10,5,5,5,5,5,5,20,10,5,5,5,10,5,5,10,20,5,10,5,10,10,10,5,20,5,5,20,10,10,5,20,5,5,10,5,5,20,10,5,5,5,5,5,10,20,20,5,5,5,20,20,10,20,10,5,5,20,10,5,5,5,5,10,5,10,5,5,20,10,5,5,20,5,5,20,5,5,5,5,5,5,5,5,20,10,5,5,5,10,5,5,5,20,5,10,5,5,10,20,5,10,5,20,5,10,5,5,5,5,5,20,5,5,5,5,5,20,5,5,10,10,20,20,5,5,10,20,20,5,20,5,5,5,5,5,5,10,5,20,10,20,20,5,5,5,5,5,5,20,5,10,20,5,5,20,5,5,5,5,20,20,5,5,5,10,10,5,5,5,5,20,5,5,20,5,20,20,5,20,5,5,5,5,20,20,5,10,5,5,10,10,10,5,20,10,10,10,20,10,5,5,5,5,5,10,20,10,20,5,10,5,5,20,10,20,5,20,5,10,5,5,5,20,10,20,5,5,5,10,10,5,10,5,5,5,5,5,20,5,5,20,5,20,20,20,20,5,5,5,10,5,20,5,10,20,20,10,5,20,5,20,5,5,10,5,5,5,5,5,5,5,5,20,5,10,5,5,20,5,20,5,5,5,5,5,20,5,5,10,10,10,5,5,5,10,10,5,5,5,5,5,10,20,5,20,5,20,20,10,5,5,20,10,5,10,5,5,5,5,5,5,20,20,20,20,5,5,5,10,5,10,10,10,5,5,5,5,5,10,5,20,5,20,5,5,5,5,5,5,20,5,5,10,20,10,5,20,20,5,20,20,5,5,5,5,5,10,5,5,10,10,5,5,5,5,5,5,5,5,5,20,5,5,5,10,10,5,5,5,5,5,5,5,10,20,5,5,20,10,5,20,5,5,20,10,10,10,5,10,10,5,5,5,20,10,5,10,20,5,5,10,5,5,5,5,5,5,10,5,5,20,5,5,20,20,10,5,5,5,10,5,5,5,20,5,5,10,5,10,10,20,5,5,20,5,20,20,5,20,5,5,5,5,20,10,5,20,5,20,5,5,20,5,5,10,20,5,20,10,5,5,20,5,20,5,10,5,5,5,10,10,5,20,10,5,20,20,5,20,5,5,20,5,10,5,5,5,5,20,10,5,5,10,5,5,5,20,5,5,5,5,20,5,5,5,10,20,5,5,5,5,5,5,5,5,5,5,10,20,10,5,5,5,5,20,5,5,10,20,5,5,5,5,10,20,5,5,5,10,5,5,5,5,5,20,20,20,5,5,5,5,5,5,20,5,20,20,10,5,10,5,5,5,5,5,5,5,5,10,20,10,20,20,10,5,20,5,10,20,10,20,5,5,10,20,5,5,5,5,20,20,5,10,10,20,5,5,5,5,5,5,20,5,10,5,20,10,5,5,5,5,5,5,5,5,5,5,5,10,5,5,5,5,5,5,5,20,5,20,5,5,5,5,5,5,5,10,10,20,20,5,5,20,10,20,5,10,10,10,20,20,5,20,20,5,10,10,20,5,10,10,5,5,20,5,5,20,10,5,20,20,5,5,20,5,5,5,20,20,5,5,5,5,10,20,5,5,20,5,20,10,10,10,5,20,5,10,10,10,20,20,5,5,5,10,5,20,5,5,5,5,5,5,5,5,5,5,20,5,5,10,5,5,10,5,5,5,5,5,5,5,20,10,20,5,20,5,5,5,5,5,20,5,5,5,20,5,5,5,5,5,20,20,10,5,5,10,5,5,10,10,20,20,5,5,20,10,5,5,5,5,5,20,10,5,5,10,10,5,10,5,10,5,5,20,20,20,10,20,5,5,20,5,5,5,20,20,10,5,5,20,20,5,5,10,5,5,20,5,20,10,10,20,5,5,5,10,20,5,5,20,5,5,5,5,5,10,5,5,20,5,5,20,20,20,5,10,5,5,5,5,5,5,5,5,5,20,5,5,20,5,5,5,10,20,20,10,5,10,5,5,10,10,10,5,5,5,10,5,5,10,5,5,5,20,5,5,10,5,5,5,5,5,5,10,20,10,5,5,20,20,10,5,10,5,5,5,5,5,5,5,5,5,5,5,5,5,20,5,10,20,20,5,10,5,10,10,5,5,5,5,5,20,5,20,10,20,5,20,5,5,5,10,5,10,5,5,5,5,10,5,10,20,5,5,5,10,5,5,10,5,10,5,10,5,10,20,5,5,5,5,5,5,5,5,5,5,10,20,20,20,10,5,5,10,5,5,5,5,20,5,5,20,5,20,5,5,5,5,5,5,5,20,5,10,5,5,20,5,5,20,20,5,20,20,5,10,5,5,5,5,20,5,5,10,20,10,20,5,20,5,20,20,10,5,5,5,5,5,5,10,5,5,20,10,20,5,5,5,5,10,5,20,5,5,5,10,5,20,20,5,20,5,5,20,5,20,5,5,10,5,5,20,5,5,5,5,5,10,20,20,5,5,5,10,5,20,5,10,5,10,20,5,10,5,5,5,5,20,5,10,5,5,5,5,10,10,20,20,20,5,10,5,5,20,5,5,5,5,10,10,10,5,20,5,10,5,10,10,5,20,5,5,10,20,20,5,5,5,5,5,5,5,5,10,20,10,5,5,10,10,20,5,5,5,5,5,20,5,10,5,10,5,5,5,20,10,20,5,10,5,5,5,20,5,5,5,5,5,10,5,5,20,5,5,5,5,5,5,10,5,10,20,5,5,5,10,5,10,5,20,10,20,5,5,5,5,5,5,5,10,20,5,20,20,5,5,10,20,10,5,5,5,5,10,20,5,5,5,5,5,10,10,5,5,5,5,10,5,10,10,10,10,5,5,20,5,5,5,20,5,20,5,10,10,5,5,5,5,5,10,10,20,20,5,5,5,5,10,5,10,5,20,5,5,10,5,5,5,10,10,20,5,10,5,5,5,5,10,20,5,10,5,5,5,10,5,5,5,5,10,5,5,5,20,5,5,10,5,5,5,5,20,20,5,5,5,5,10,5,10,5,10,10,5,5,10,10,5,5,5,10,5,10,20,10,20,20,5,5,5,5,10,5,20,5,5,10,5,5,20,5,5,5,5,20,10,5,10,20,10,20,5,5,5,5,5,5,5,20,20,10,5,5,20,5,20,10,20,10,5,20,5,20,10,20,20,5,5,20,5,20,10,5,5,5,10,5,5,5,5,5,5,5,5,10,10,20,5,5,10,10,20,20,5,10,5,5,5,5,10,5,5,10,5,5,20,5,20,10,5,5,5,20,5,10,5,20,20,5,5,10,10,5,5,5,20,20,5,5,5,20,10,5,5,10,5,5,5,5,5,10,5,10,5,5,5,20,5,10,5,5,5,20,10,5,5,10,5,10,5,5,10,20,10,5,5,20,5,5,20,5,5,5,5,10,5,10,5,5,5,20,5,10,5,10,20,20,20,5,10,20,5,5,5,5,10,5,5,5,10,5,20,20,10,5,5,5,10,5,20,20,5,10,20,10,10,10,20,5,5,20,5,20,10,20,20,5,20,10,10,5,5,10,10,5,10,20,20,5,10,10,5,5,5,5,5,20,5,5,10,10,10,5,10,5,5,10,20,5,20,5,10,5,5,20,20,10,5,10,10,5,20,10,10,5,5,5,20,10,10,20,5,5,20,5,10,5,10,10,20,5,5,5,10,20,10,10,5,5,5,10,5,10,5,20,10,5,5,5,20,5,5,10,20,5,10,10,5,20,5,5,20,5,5,5,20,5,5,5,5,10,10,5,5,10,10,5,20,5,5,10,10,5,5,10,5,20,10,5,20,5,5,5,10,20,5,10,5,20,5,5,5,5,5,10,5,5,10,5,20,5,10,5,5,20,5,5,5,10,5,20,20,20,5,10,5,5,5,5,5,10,20,10,5,5,5,20,10,10,20,5,5,5,5,10,10,5,20,5,20,20,5,20,10,5,20,5,5,5,10,20,20,5,5,5,5,5,5,20,10,20,20,5,5,5,5,5,5,10,10,20,5,5,5,10,5,10,5,10,5,20,10,5,5,5,5,5,20,20,20,5,5,5,5,10,5,5,20,5,10,10,20,5,5,5,10,5,5,20,5,20,5,10,5,5,5,5,5,5,5,5,5,5,5,5,5,10,20,5,20,5,5,5,20,5,20,20,5,5,5,10,5,20,10,5,10,20,5,20,10,5,5,10,20,5,20,5,20,20,5,20,5,10,10,5,5,5,5,20,5,5,20,20,5,5,5,10,20,5,5,20,5,5,5,10,10,5,10,5,20,10,10,5,20,10,20,5,5,5,5,5,5,20,10,20,5,10,5,5,10,20,5,5,10,5,5,20,5,5,5,10,20,10,5,5,20,5,5,5,5,20,20,10,5,20,5,5,5,5,5,5,5,20,5,5,10,20,20,5,5,10,20,5,5,10,5,5,5,5,20,5,5,20,10,5,5,5,20,5,10,5,5,5,10,20,5,10,20,5,5,5,5,5,5,5,10,5,20,5,20,20,5,5,5,5,20,5,20,5,10,5,5,5,5,5,5,5,5,5,5,10,5,10,5,5,20,5,5,20,5,5,20,20,20,5,5,5,5,5,10,5,10,10,20,20,20,5,5,5,20,5,5,5,20,10,5,5,10,5,20,5,10,5,5,10,20,5,20,10,20,20,5,10,10,10,10,10,20,20,20,5,5,5,5,5,20,10,5,5,20,20,5,10,5,10,5,10,10,5,10,5,5,20,5,10,5,10,10,20,5,10,5,20,5,10,5,10,20,10,20,5,5,5,5,5,10,20,5,5,5,5,20,20,5,20,5,5,5,20,5,5,20,5,5,5,5,10,5,5,5,5,5,5,10,5,5,5,5,20,20,10,20,5,5,5,5,5,10,20,10,5,5,5,5,10,5,5,10,5,5,5,5,10,10,20,5,5,20,5,5,10,5,10,5,5,5,5,5,5,20,5,5,20,5,20,5,20,5,20,10,5,5,10,5,20,5,5,5,10,10,20,5,5,5,20,10,20,5,5,5,5,5,10,5,5,5,5,20,10,5,10,20,20,5,20,20,10,20,10,10,10,5,5,10,20,5,10,5,5,20,10,5,10,5,10,10,10,20,20,5,20,5,10,5,10,5,5,5,20,5,20,20,5,10,5,5,5,5,5,20,5,5,5,20,5,5,5,5,5,5,5,5,5,5,5,20,5,5,5,10,5,5,20,5,5,10,20,10,10,10,5,10,5,5,10,5,5,5,10,5,5,5,20,20,5,20,5,5,5,20,5,20,5,5,5,20,5,20,20,5,5,10,20,20,5,5,5,20,5,5,20,5,5,20,5,20,10,5,5,5,5,20,10,20,10,20,10,5,5,10,5,5,5,5,5,5,5,5,5,5,10,10,5,20,20,5,20,20,5,10,10,5,5,5,5,5,5,10,20,20,5,5,5,20,5,5,5,5,10,5,5,20,5,5,20,20,20,10,20,5,5,5,10,5,5,20,5,20,20,5,10,20,5,5,10,5,10,5,5,5,5,5,5,5,10,10,5,5,5,5,20,5,5,10,20,5,10,5,10,5,10,20,5,5,5,5,5,10,20,5,10,10,10,5,5,5,5,10,20,20,5,20,20,5,10,5,5,5,10,20,10,5,5,5,5,5,5,5,20,20,5,5,5,5,5,10,5,20,5,20,10,5,10,5,5,5,10,5,10,5,20,5,5,10,5,20,5,5,5,10,5,20,20,20,10,5,10,10,10,5,5,5,5,20,5,20,10,5,5,5,5,5,5,10,5,20,20,10,10,20,5,5,5,10,10,5,20,5,10,20,20,5,20,5,5,5,5,5,10,5,5,5,10,5,10,5,20,5,10,10,10,5,5,10,5,10,5,5,20,5,5,5,5,5,5,10,5,5,10,10,5,20,20,5,5,5,20,5,20,20,5,20,10,10,10,5,5,10,20,10,5,5,20,5,5,10,5,20,5,5,5,5,5,20,5,5,20,10,5,5,5,5,10,5,5,5,20,5,5,20,10,10,5,10,10,5,20,10,20,10,10,10,5,5,10,5,5,5,10,5,5,5,5,5,5,5,5,5,5,20,5,10,5,5,5,5,5,5,5,20,20,20,5,5,5,10,10,5,5,20,20,5,5,5,20,10,20,5,5,20,5,5,20,10,20,5,5,20,10,10,20,20,5,5,20,20,5,5,20,5,5,5,5,5,10,5,5,20,5,5,20,20,5,20,5,10,5,5,20,5,20,10,5,5,5,5,5,5,10,5,5,5,20,5,5,10,20,10,5,5,20,10,10,20,20,5,10,10,20,20,5,5,20,20,5,10,5,5,5,5,5,5,5,5,5,10,20,5,5,5,5,20,10,10,20,20,5,5,20,10,5,5,10,5,5,20,10,5,20,5,10,10,5,5,10,20,5,20,5,5,20,5,5,10,5,5,10,5,5,10,5,5,5,5,5,10,5,5,20,20,20,5,5,5,5,5,5,10,5,20,10,5,10,20,5,5,5,10,10,20,5,10,10,10,10,5,5,20,5,5,5,10,5,5,10,10,20,5,5,10,10,20,10,5,5,5,5,20,20,5,20,5,20,5,10,5,5,5,5,5,5,5,20,5,5,5,5,10,5,20,10,5,5,20,5,20,10,5,5,5,5,20,5,20,10,5,5,5,10,20,5,10,10,5,5,5,5,10,5,20,5,5,5,20,10,5,10,5,10,5,5,10,5,5,5,5,5,10,5,20,5,10,5,20,20,5,5,5,5,10,5,10,5,5,20,5,10,5,10,5,5,20,5,10,5,20,20,5,20,5,20,5,5,5,5,20,10,5,5,5,5,10,5,10,10,20,20,5,5,5,10,5,20,5,10,10,5,5,20,5,5,5,5,10,10,10,10,10,20,5,10,5,20,5,10,20,10,10,5,5,5,5,5,10,5,5,5,5,10,5,10,10,20,5,5,5,5,20,5,20,20,20,5,5,5,5,5,10,5,5,5,20,5,5,5,5,20,20,5,10,10,5,5,20,20,5,10,5,10,10,5,10,20,20,5,10,20,10,20,5,5,5,10,20,5,10,5,5,5,20,5,10,5,5,5,5,20,10,10,5,5,5,10,5,20,5,5,5,5,5,10,5,5,5,5,5,5,10,10,5,10,5,10,5,5,5,5,5,20,10,5,5,20,10,20,5,10,20,10,5,5,5,5,20,10,20,5,10,10,5,10,20,5,20,5,20,5,5,5,5,5,5,10,5,5,5,5,5,5,5,10,20,10,20,5,20,5,5,10,20,5,5,5,5,20,20,20,10,5,5,5,5,20,5,5,5,5,5,10,5,20,5,5,10,20,5,20,5,5,5,5,20,10,10,5,10,10,5,5,5,10,20,20,20,5,5,5,10,5,5,20,5,10,10,5,10,5,5,10,5,10,5,5,5,20,10,10,20,5,20,5,5,5,10,5,10,5,5,20,5,10,5,20,5,20,5,10,5,5,5,5,10,5,5,5,5,5,5,5,5,5,5,20,20,5,10,5,5,20,5,20,10,10,20,5,5,5,5,5,5,5,5,20,5,5,5,5,5,5,5,5,20,5,5,5,20,5,5,5,20,5,5,20,20,5,5,5,20,10,5,5,20,5,5,5,5,5,5,20,10,5,5,5,5,10,5,5,5,20,5,5,20,5,10,5,5,10,20,10,5,20,5,5,5,10,20,10,5,10,5,5,5,5,5,20,20,20,20,5,20,20,5,5,5,10,10,5,20,5,20,5,5,5,20,10,5,5,5,20,10,5,20,5,20,20,5,5,10,5,5,5,5,5,5,10,20,10,20,5,5,10,5,20,5,5,10,10,5,5,5,20,10,10,5,5,10,5,5,5,20,5,20,5,5,20,5,20,10,20,20,5,5,10,5,5,20,5,10,5,5,5,10,5,5,5,5,5,5,5,10,5,5,5,5,20,5,5,5,5,5,5,20,10,5,10,5,5,5,20,20,10,5,5,5,5,20,5,5,10,10,5,5,10,10,5,10,5,5,10,10,5,5,5,20,10,10,5,10,5,5,20,5,5,20,5,5,10,20,5,10,5,5,5,5,5,5,5,5,20,5,20,5,10,5,5,10,5,5,5,10,5,5,10,10,10,5,5,20,20,5,5,5,5,20,5,5,5,5,10,20,5,10,10,5,5,20,20,5,5,5,5,5,20,20,10,20,20,10,10,5,20,20,5,5,20,10,10,20,5,5,5,5,5,5,20,5,5,10,20,5,5,5,5,5,20,10,10,5,5,5,5,5,10,5,20,5,5,5,20,10,10,10,5,10,5,5,5,20,5,10,20,20,5,5,5,5,20,10,10,10,20,5,5,20,5,5,5,5,5,10,5,20,5,10,5,20,5,5,20,10,20,5,5,10,5,5,5,5,5,5,5,5,20,20,5,5,20,5,10,10,5,5,10,10,20,5,5,20,10,10,20,5,20,5,5,10,5,10,5,20,10,5,5,10,10,5,5,5,5,20,5,10,5,10,5,10,20,5,5,10,20,5,10,5,5,5,10,5,5,10,5,10,10,5,20,10,5,5,5,20,5,10,5,5,5,5,5,20,5,20,20,5,20,5,5,10,5,20,5,5,20,20,20,20,10,5,10,5,5,20,10,5,5,10,5,5,5,5,5,10,5,5,5,5,5,5,5,5,5,10,5,5,5,5,10,10,5,5,5,5,5,5,5,10,5,5,5,5,5,10,5,5,20,10,20,10,10,20,20,5,5,10,5,5,5,10,5,10,5,5,10,5,5,5,5,10,10,5,10,5,20,5,20,5,5,5,5,5,20,5,10,20,5,20,10,5,5,5,5,10,10,20,10,20,5,10,5,20,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,20,5,5,5,10,20,5,20,5,5,5,5,10,5,5,5,5,5,10,10,10,20,10,10,20,5,5,20,5,10,5,5,5,5,5,5,5,20,10,5,20,5,10,20,10,20,5,5,5,5,5,5,20,5,5,20,20,5,10,5,5,10,5,5,20,5,5,5,20,5,20,10,5,5,5,10,10,20,5,10,10,5,20,10,5,5,10,20,20,5,5,5,5,10,5,5,10,20,5,10,5,10,5,5,10,5,20,5,10,5,20,20,10,5,20,10,5,5,5,10,10,10,20,20,5,20,10,5,5,5,5,5,20,5,10,5,5,10,10,5,10,5,5,10,20,5,5,5,5,5,5,10,5,20,10,20,20,5,5,5,10,5,20,5,5,5,5,5,5,5,5,20,10,5,5,20,5,5,20,5,20,5,5,5,10,5,5,5,5,5,5,5,5,10,5,5,10,5,20,10,5,20,5,5,10,5,5,20,5,5,10,5,20,5,5,10,5,20,5,10,5,20,20,5,5,5,20,20,5,5,5,20,5,5,20,10,20,5,5,5,10,5,5,5,5,10,5,5,5,20,20,5,5,5,20,5,10,10,10,5,5,5,5,20,5,5,10,5,20,5,5,5,5,5,5,5,10,5,5,5,20,5,5,10,5,5,5,5,5,5,20,5,5,5,5,5,10,20,5,5,20,5,20,5,5,20,10,5,5,5,20,10,5,20,20,5,5,5,5,20,20,5,5,5,5,5,20,5,10,10,5,20,5,10,5,5,10,5,20,20,5,5,20,5,10,5,5,20,5,10,10,5,5,5,5,5,5,5,5,20,20,5,20,20,5,5,5,5,5,5,10,5,5,5,5,5,5,10,5,5,20,5,5,5,20,5,5,20,20,5,5,5,10,5,10,20,5,5,5,5,10,5,5,10,5,5,10,5,5,20,5,5,5,5,5,5,5,10,5,5,20,5,5,10,5,5,5,5,5,5,5,5,20,10,5,5,5,5,5,5,20,10,5,10,5,10,5,10,20,20,20,10,5,5,10,5,10,5,5,5,5,5,5,5,5,10,5,10,5,5,5,5,10,10,20,20,5,5,20,5,5,10,20,20,10,5,5,5,5,5,5,20,5,5,10,20,20,10,5,5,5,5,5,5,5,20,10,5,5,10,5,5,5,10,5,5,20,20,5,5,5,5,20,5,20,5,5,5,5,5,5,10,5,5,5,5,5,5,5,5,5,5,20,5,10,20,20,20,10,5,5,5,5,10,5,5,20,20,5,20,5,10,5,5,5,5,5,5,20,10,5,5,5,5,5,5,5,5,5,5,20,5,5,5,5,5,20,5,5,20,10,10,5,5,5,5,5,5,20,10,5,20,5,20,5,5,5,5,5,10,5,5,20,20,5,10,20,5,10,5,20,5,5,5,5,5,5,10,20,5,5,5,10,10,5,20,5,5,10,5,5,10,10,5,5,20,10,5,5,20,10,10,5,5,20,5,5,5,20,5,10,10,5,5,5,5,5,5,5,20,10,20,20,5,20,5,5,5,5,5,5,5,20,10,10,5,5,5,5,20,5,5,20,5,10,5,5,5,10,20,10,5,20,20,10,20,10,20,10,5,5,5,5,5,10,10,5,5,5,5,10,10,5,5,5,5,5,5,5,5,5,10,5,10,5,5,20,20,10,5,5,20,5,5,5,5,5,5,5,5,20,20,5,10,20,10,5,10,5,20,5,5,10,5,10,20,5,5,5,20,5,5,5,5,10,5,20,20,5,5,20,20,10,20,20,10,5,5,5,5,10,10,5,20,10,5,5,20,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5,5,5,20,5,5,10,20,5,10,5,5,10,20,5,5,10,5,5,20,5,5,10,10,5,5,5,5,5,5,5,5,5,5,20,5,5,10,10,20,5,5,10,5,5,5,20,5,20,5,20,5,5,10,5,20,5,5,5,5,5,5,5,10,5,10,5,20,5,20,5,10,5,5,5,5,10,5,5,5,10,5,20,5,5,5,5,5,20,5,5,5,5,10,5,5,10,10,10,20,5,5,20,20,5,5,5,5,5,5,5,5,5,20,10,5,10,20,5,5,5,5,5,5,20,5,20,5,10,10,5,5,5,20,5,5,5,5,5,5,10,10,5,5,5,5,5,5,20,5,5,5,5,20,5,5,20,5,10,20,5,10,10,5,5,5,5,20,10,5,5,5,5,20,20,20,5,5,5,10,5,5,5,5,10,5,5,5,20,20,5,20,5,5,10,5,5,5,5,20,10,5,10,5,5,5,5,5,5,5,20,5,10,5,10,5,5,5,5,20,20,5,5,5,20,5,5,5,20,5,10,5,5,10,5,5,5,5,5,10,20,5,10,10,5,5,10,5,5,5,10,20,5,20,5,10,5,5,10,5,5,5,5,5,5,5,5,5,5,20,5,5,5,5,5,5,5,5,10,20,10,20,5,10,20,5,5,10,5,5,5,5,10,5,10,20,5,5,20,10,5,20,20,5,5,5,5,5,5,5,5,5,10,5,5,5,20,5,20,20,5,5,5,5,10,5,20,5,20,5,5,5,20,5,20,5,5,20,10,5,10,5,5,10,5,5,5,5,5,5,5,10,10,10,20,10,5,5,10,5,20,5,20,5,20,5,5,5,5,10,5,5,10,5,5,5,5,5,5,20,5,20,5,5,5,20,5,20,20,20,5,5,5,20,5,10,20,5,10,20,20,5,5,5,20,5,5,5,5,10,5,20,20,5,5,5,20,10,5,5,20,5,20,5,5,20,20,5,10,5,5,20,10,20,10,10,20,5,5,10,10,20,10,5,5,5,10,20,5,5,20,5,20,5,10,5,5,20,20,5,5,5,5,5,5,5,10,20,5,5,5,20,5,5,20,5,20,5,20,5,5,10,5,5,10,10,5,5,5,5,5,20,10,10,5,5,5,20,10,5,5,5,5,20,20,5,10,10,5,5,5,10,5,5,10,20,20,5,5,10,10,10,5,5,5,5,5,20,10,5,5,5,20,20,20,20,20,5,5,5,20,10,20,20,5,5,5,10,20,5,10,10,5,10,5,5,10,5,10,20,5,5,10,5,20,5,5,20,5,5,5,20,5,5,5,5,10,20,10,10,5,5,10,5,5,5,10,5,5,20,20,20,20,5,5,20,5,5,5,5,5,5,5,5,5,5,5,5,20,5,5,20,20,10,20,5,20,10,10,5,5,10,5,5,20,5,20,5,10,5,10,5,5,10,10,20,20,20,5,10,5,10,5,20,10,5,5,5,20,20,20,20,5,5,5,5,10,5,5,5,5,20,5,5,10,10,20,5,5,10,5,10,5,5,20,10,20,5,5,5,10,5,5,20,5,5,20,10,5,5,10,10,5,10,5,5,5,20,10,5,10,20,5,5,5,5,5,20,5,5,5,20,5,5,5,20,10,5,20,10,10,20,5,5,5,5,5,5,5,5,5,10,5,5,5,5,5,5,20,5,5,5,5,5,5,20,5,5,5,20,5,20,5,20,20,10,5,10,20,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,20,5,5,5,20,5,5,20,5,5,5,5,20,5,20,10,5,5,5,5,5,5,5,5,5,20,5,5,20,20,5,5,5,5,5,5,5,5,5,5,20,5,5,5,20,5,20,10,5,20,5,5,5,20,20,5,10,5,10,5,10,10,10,5,5,5,5,5,5,5,5,10,10,5,10,5,20,10,5,5,5,5,5,5,10,5,5,20,5,10,5,5,20,5,10,5,5,20,5,20,5,5,20,20,20,5,5,20,5,20,5,20,5,5,20,5,5,5,5,10,5,5,5,10,5,10,10,5,5,5,5,5,5,5,20,10,5,5,5,20,5,20,5,5,20,5,5,5,5,5,5,20,5,5,20,20,5,5,5,10,5,5,5,10,5,20,5,5,20,5,5,5,5,10,5,10,5,10,10,5,5,10,5,20,20,10,5,10,10,20,5,10,5,5,5,10,5,10,5,5,5,10,5,20,5,5,5,10,20,20,5,5,10,5,20,5,20,5,10,5,10,5,5,5,5,10,5,5,5,5,5,5,20,5,5,5,5,5,20,5,5,10,5,5,5,5,5,10,5,20,5,5,20,5,20,5,5,20,5,20,5,5,10,5,5,5,5,5,5,20,20,5,10,5,10,5,5,5,10,5,5,5,20,5,5,5,10,5,5,5,10,10,5,20,5,5,10,5,5,5,20,5,5,10,5,10,5,10,5,5,5,5,5,20,10,10,5,20,5,5,5,10,10,5,5,5,10,10,5,5,20,5,5,5,5,5,5,5,10,5,20,10,20,5,5,5,5,5,5,20,10,5,20,20,10,5,5,10,10,10,5,10,5,10,20,20,20,20,10,5,5,20,20,20,5,20,20,5,5,5,5,5,10,5,5,5,5,10,20,5,10,10,5,5,5,5,10,5,5,5,5,20,10,5,5,5,20,20,5,10,5,10,5,20,5,5,5,10,5,5,10,20,5,5,20,5,5,10,5,20,5,10,5,10,10,10,10,5,5,20,5,20,20,5,20,20,5,10,20,5,5,5,5,5,5,5,20,20,5,10,10,10,5,5,5,10,5,5,5,20,5,5,5,10,20,5,10,20,10,20,10,5,5,5,5,10,10,5,5,20,20,20,5,20,20,5,5,20,5,10,5,10,5,5,5,5,5,5,5,20,5,10,10,5,20,10,5,5,5,5,5,5,10,5,5,5,20,5,5,5,5,5,20,20,5,5,5,5,10,20,10,5,5,20,20,10,20,20,20,5,10,20,5,5,10,10,20,10,10,5,5,20,5,5,5,20,5,5,5,5,20,10,5,10,5,10,10,10,10,5,5,5,20,5,5,5,5,5,5,5,20,5,20,5,10,10,10,5,5,5,10,5,5,20,20,5,5,20,5,10,10,20,20,5,5,10,10,5,5,20,5,5,5,5,10,20,5,5,5,10,20,5,5,20,5,5,5,5,10,10,5,5,20,5,5,5,20,5,5,5,5,5,5,5,20,20,5,5,5,5,20,20,20,10,5,5,5,5,10,20,5,20,20,20,5,5,5,5,10,20,5,5,5,5,5,5,5,20,5,5,5,10,20,20,5,5,5,5,20,5,20,5,5,5,5,5,5,10,10,10,5,20,10,5,5,20,20,5,20,10,5,10,5,20,20,5,10,5,5,5,5,5,5,5,5,5,20,20,5,20,20,5,20,10,10,20,5,5,20,5,5,5,5,10,5,5,5,10,5,5,10,10,20,10,5,5,5,5,5,10,5,5,5,5,10,5,10,5,5,5,5,5,5,5,5,10,10,5,5,10,5,10,10,5,5,20,20,10,10,5,5,20,20,5,5,5,5,5,10,20,10}));


    }


}
