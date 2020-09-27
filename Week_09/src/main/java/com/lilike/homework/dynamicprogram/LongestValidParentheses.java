package com.lilike.homework.dynamicprogram;

import java.util.Stack;

/**
 *
 *  最长有效括号
 *  https://leetcode-cn.com/problems/longest-valid-parentheses/
 * @Author llk
 * @Date 2020/9/25 9:55
 * @Version 1.0
 */
public class LongestValidParentheses {

    /**
     *  ))(()(())))(()()(()
     *  用栈的方式,消除一对括号,就加上2
     *  "()(()"
     *   () ) (()) )
     *   ()()() )(()()((()
     *   注意: 需要的是连续的才行
     *  连续的往栈里面放左括号,
     *      如果遇到右边的括号,进行消除,如果遇到不能消除的情况,清空栈,然后重新开始计数
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {




        return 0;
    }


    public static void main(String[] args) {



    }

}
