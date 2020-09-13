package com.lilike.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author llk
 * @Date 2020/9/10 22:35
 * @Version 1.0
 */
public class GenerateParenthesis {


    /**
     *  合法的括号
     *  左边的括号可以一直加,同时的话,右边的括号不能比左边的括号多
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<String>();
        if (n == 0) return new ArrayList<String>();
        dg(n,result,"",0,0);
        return result;
    }

    private void dg(int n, List<String> result, String s, int l, int r) {
        if (l >= n && r >= n) {
            result.add(s);
            return ;
        }

        if (l < n)
            dg(n,result,s+"(",l+1,r);

        if (r < n && r<l)
            dg(n,result,s+")",l,r+1);

    }


    public static void main(String[] args) {

    }

}
