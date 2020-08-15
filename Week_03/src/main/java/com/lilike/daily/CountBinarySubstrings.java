package com.lilike.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/count-binary-substrings/
 * 计数二进制子串
 *
 * @Author llk
 * @Date 2020/8/10 19:40
 * @Version 1.0
 */
public class CountBinarySubstrings {


    /**
     *  对于任何一个 0-1组成的子串
     *  1. 首先将他们进行分组 比如 0011101100 分为 {2,3,1,2,2}
     *  2. 要说相同的子串,相邻的组 组成相同子串的数目是
     *      math.min(A(n-1),A(n))
     *
     *  3. 将所有相邻的计算结果相加
     *
     *
     *
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {

        if (s.length() < 2) {
            return 0;
        }

        List<Integer> groupStat = getGroupStat(s);

        int sum = 0;
        for (int i = 0; i < groupStat.size()-1; i++) {
            int min = Math.min(groupStat.get(i), groupStat.get(i + 1));
            sum += min;
        }

        return sum;
    }

    public List<Integer> getGroupStat(String s) {
        List<Integer> groupStat = new ArrayList<>();

        char[] chars = s.toCharArray();

        int t = 0;
        Character temp = null;
        for (char aChar : chars) {
            if (temp == null) {
                temp = aChar;
                t++;
            } else if (aChar == temp) {
                t++;
            } else {
                temp = aChar;
                groupStat.add(t);
                t = 1;
            }
        }
        groupStat.add(t);
        return groupStat;
    }


    public static void main(String[] args) {

        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110"));
    }

}
