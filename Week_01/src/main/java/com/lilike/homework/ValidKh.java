package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/***
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 有效的括号
 * @file ValidKh.java
 * @author lyric
 * @date 2020/8/2
 */
public class ValidKh {

    public static void main(String[] args) {

        System.out.println(new ValidKh().solution1("()[]{}"));
        System.out.println(new ValidKh().solution1(")[)]"));

    }

    public static Map<Character,Character> map = new HashMap<>();

    static {
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
    }

    /**
     *
     * @param str
     * @return
     */
    public boolean solution1(String str) {

        Stack<Character> stack = new Stack();

        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (map.keySet().contains(aChar)) {
                stack.push(aChar);
            }else {
                if (stack.size() == 0) return false;
                if (!map.get(stack.pop()).equals(aChar)) {
                    return false;
                }
            }
        }
        return true;
    }

}
