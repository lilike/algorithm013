package com.lilike.homework.stringalgorith;

/**
 * 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @Author llk
 * @Date 2020/9/26 21:11
 * @Version 1.0
 */
public class LongestCommonPrefix {


    /**
     *  最长公共子串
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int ans = 0;
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLength = Math.min(minLength,strs[i].length());
        }

        for (int i = 0; i < minLength; i++) {
            char flag = strs[0].charAt(i);
            boolean f = true;
            for (int j = 1; j < strs.length; j++) {
                if (flag != strs[j].charAt(i)) {
                 f = false;
                 break;
                }
            }
            if (f) {
                ans++;
            }else {
                break;
            }
        }
        return strs[0].substring(0,ans);
    }


    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"aca","cba"}));
    }

}
