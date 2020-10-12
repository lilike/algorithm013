package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @Author llk
 * @Date 2020/10/9 16:00
 * @Version 1.0
 */
public class LengthOfLongestSubstring {


    /**
     * 首先定义一个Hash表,
     * key 保存的是字符, value 保存的是索引
     * 定义两个指针,一个是left  一个是right
     * right不断的向右边移动
     * 如果hash表里面不存在的话,把 key, index 存入到hash表当中
     * <p>
     * 如果hash表里面存在了,
     * 那么就把左边的指针left 变成 map.get(key)+1
     * <p>
     * 然后 比较 max 和 right-left+1 的大小
     * <p>
     * 最终返回max
     * <p>
     * 典型的使用hash表进行降维时间复杂度
     * 用空间来换时间的做法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int left = 0, right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }

            map.put(c, right);
            max = Math.max(max, right - left + 1);

        }
        return max;
    }


    /**
     * 用labuladong的模板来解决这个问题
     * 实际上是一个窗口滑动问题
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        // 开始进行滑动
        int left =  0, right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // 如果已经存在了,则表示已经访问过了,移动或是不移动左边的指针.
            if (map.containsKey(c)) {
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,right);

            max = Math.max(max,right-left+1);
            right++;
        }
        return max;
    }


    public static void main(String[] args) {

        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring("abcb"));
    }

}
