package com.lilike.homework.seven;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 *
 * @Author llk
 * @Date 2020/8/10 9:18
 * @Version 1.0
 */
public class GenerateParenthesis {






    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        _generate(0, 0, n, "",result);
        return result;
    }

    /**
     * 1. 左括号不能小于右边括号
     * 2. 只有左括号数量以及右边括号数量小于n的时候才会添加
     *
     * @param i 左括号数量
     * @param j 右括号数量
     * @param n n组括号
     * @param s 字符串
     */
    private void _generate(int i, int j, int n, String s,List<String> result) {

        // terminator
        if (i == n && j == n) {
            result.add(s);
            return;
        }

        // process
        // drill down
        if (i < n)
            _generate(i + 1, j, n, s + "(",result);

        if (j < n && j < i)
            _generate(i, j + 1, n, s + ")",result);


    }


    /**
     * 思路1 : 从一个 "" 开始不断的往这个空串添加 "(" 或是 ")"
     * 一旦达到了长度为6跳出递归,并且校验一下字符串,
     * 校验的规则就是
     * 发现 ( 记做 +1
     * 发现 ) 记做 -1
     * 如果提前变成负数 那么校验失败
     * 校验到最后不等于0 依然是校验失败
     * 否则 校验成功
     *
     * @param n 表示生成n对括号
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dg("", 3, result);
        return result;
    }


    public void dg(String str, int n, List<String> result) {
        if (str.length() == (2 * n)) {
            if (isValid(str)) {
                result.add(str);
            }
            return;
        }

        dg(str + "(", n, result);
        dg(str + ")", n, result);

    }

    private boolean isValid(String str) {
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) {
                return false;
            }
        }
        if (flag != 0) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
    }

}
