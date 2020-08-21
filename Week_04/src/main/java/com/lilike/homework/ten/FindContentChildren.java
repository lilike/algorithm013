package com.lilike.homework.ten;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/assign-cookies/description/
 * 分发饼干
 * @Author llk
 * @Date 2020/8/18 22:55
 * @Version 1.0
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {

        int num = 0;
        PriorityQueue<Integer> gP = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i : g) {
            gP.add(i);
        }
        PriorityQueue<Integer> sP = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for (int i : s) {
            sP.add(i);
        }

        while (sP.size() > 0 && gP.size() > 0) {

            Integer cookie = sP.poll();
            while (gP.size() > 0) {
                Integer child = gP.poll();
                if (cookie >= child) {
                    num++;
                    break;
                }
            }
        }
        return num;
    }




    }
