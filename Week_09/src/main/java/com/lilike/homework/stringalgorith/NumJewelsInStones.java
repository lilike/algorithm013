package com.lilike.homework.stringalgorith;

import java.util.*;
import java.util.stream.Collectors;

/**
 *  宝石和石头
 * @Author llk
 * @Date 2020/9/26 10:52
 * @Version 1.0
 */
public class NumJewelsInStones {

    /**
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        Set<Character> set = new HashSet<Character>();
        for (char c : J.toCharArray()) {
            set.add(c);
        }

        for (char j : S.toCharArray()) {
            if (set.contains(j)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }


}
