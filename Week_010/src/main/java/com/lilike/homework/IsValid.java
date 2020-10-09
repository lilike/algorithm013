package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @Author llk
 * @Date 2020/10/7 11:52
 * @Version 1.0
 */
public class IsValid {

    private static Map<Character, Character> map = null;

    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }


    // ()[]{}
    public boolean isValid(String s) {

        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else {
                if (stack.size() == 0) return false;
                if (map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        if (stack.size() > 0) return false;
        return true;
    }


    public boolean isValid2shortSolution(String s) {

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.size() ==0 || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("()[]{}"));
        System.out.println(new IsValid().isValid("()[{]}"));
        System.out.println(new IsValid().isValid("()[{}]"));
    }
}
