package com.lilike.daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 *  删除最外层括号
 *  https://leetcode-cn.com/problems/remove-outermost-parentheses/
 *
 * @file RemoveOuterParentheses.java
 * @author lyric
 * @date 2020/8/4
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveOuterParentheses().removeOuterParentheses("(()())(())(()(()))"));

    }

    /**
     * 分为两步,第一步是拆分原语
     * 第二部是拆外面的括号
     *
     * 代码可以继续优化
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();
        int x = 0;
        int index = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                x++;
            }else {
                x--;
            }
            if (x == 0 && i > 0) {
                String s = S.substring(index, i + 1);
                s = s.length()<3 ? "" : s.substring(1,s.length()-1);
                sb.append(s);
                index = i+1;
            }

        }
        return sb.toString();
    }


}
