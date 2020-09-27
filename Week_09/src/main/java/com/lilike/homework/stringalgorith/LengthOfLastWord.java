package com.lilike.homework.stringalgorith;

/**
 *  最后一个单词的长度
 *  https://leetcode-cn.com/problems/length-of-last-word/
 * @Author llk
 * @Date 2020/9/26 10:44
 * @Version 1.0
 */
public class LengthOfLastWord {


    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        String[] split = s.split(" ");
        if (split.length == 0) return 0;
        return split[split.length-1].length();
    }

        public static void main(String[] args) {

        }
}
