package com.lilike.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/restore-ip-addresses/
 * 复原IP地址
 *
 * @Author llk
 * @Date 2020/8/9 8:27
 * @Version 1.0
 */
public class RestoreIpAddresses {

    private final int SEGMENT_COUNT = 4;
    private List<String> result = new ArrayList<>();
    private int[] segments = new int[SEGMENT_COUNT];


    /*
        递归的思想
            递归的层数最多是4层

     */
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0);
        return result;
    }


    /**
     * 深度的值是 0 1 2 3 4 如果到了4并且startIndex = s.length,说明是匹配了一组结果
     *
     * @param s
     * @param startIndex
     * @param deep
     */
    public void dfs(String s, int startIndex, int deep) {


        // 如果到了第四层
        if (deep == 4) {
            if (startIndex == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int segment : segments) {
                    sb.append(segment + ".");
                }
                result.add(sb.substring(0, sb.length() - 1));
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (startIndex >= s.length() || deep > 4) {
            return;
        }

        // 如果没有到第四层,但是当前的值是0,那么这一位就只能是0
        if (s.charAt(startIndex) == '0') {
            segments[deep] = 0;
            dfs(s, startIndex + 1, deep + 1);
        }

        // 一般的情况
        int addr = 0;
        for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            addr = addr * 10 + (s.charAt(endIndex) - '0');
            if (addr > 0 && addr <= 255) {
                segments[deep] = addr;
                dfs(s,endIndex+1,deep+1);
            }else {
                break;
            }
        }

    }


    public static void main(String[] args) {

        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("25525511135");
        System.out.println(restoreIpAddresses.result);


    }


}
