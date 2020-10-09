package com.lilike.homework;

import java.util.Stack;

/**
 *  字符串解码
 *  https://leetcode-cn.com/problems/decode-string/
 * @Author llk
 * @Date 2020/10/7 12:25
 * @Version 1.0
 */
public class DecodeString {


    /**
     *  输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * 使用栈来进行解码
     * @param s
     * @return
     */
    public String decodeString(String s) {

        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = s.charAt(idx++) - '0';
                while (Character.isDigit(s.charAt(idx))) {
                    count = count * 10 + s.charAt(idx) - '0';
                    idx++;
                }
                countStack.push(count);
            }else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }else if (s.charAt(idx) == ']') {
                StringBuilder sb = new StringBuilder(resStack.pop());
                Integer repeatCount = countStack.pop();
                for (int i = 0; i < repeatCount; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                idx++;
            }else {
                res += s.charAt(idx);
                idx++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("100[leetcode]"));
    }

}
