package com.lilike.homework.stringalgorith;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  反转字符串里面的单词
 *  https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @Author llk
 * @Date 2020/9/26 21:48
 * @Version 1.0
 */
public class ReverseWords {


    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        List<String> res = Arrays.asList(s.trim().split(" "));
        Collections.reverse(res);
        return  res.stream().filter(x -> x.length() > 0).collect(Collectors.joining(" "));
    }


    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("example   good a"));
    }

}
