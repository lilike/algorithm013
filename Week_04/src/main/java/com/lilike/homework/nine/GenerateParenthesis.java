package com.lilike.homework.nine;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 * 生成有效的括号
 *
 * @Author llk
 * @Date 2020/8/17 16:34
 * @Version 1.0
 */
public class GenerateParenthesis {


    /***
     * 深度优先遍历 + 回溯
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, "", result);
        return result;
    }

    private void dfs(int n, String s, List<String> result) {

        // terminator
        if (s.length() == 2 * n) {
            if (isvalid(s)) {
                result.add(s);
            }
            return;
        }
        dfs(n, s + "(", result);
        dfs(n, s + ")", result);
    }

    private boolean isvalid(String s) {

        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                flag++;
            } else {
                flag--;
            }
            if (flag < 0) break;
        }

        return flag == 0 ? true : false;
    }


    public static void main(String[] args) {
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
    }

}
