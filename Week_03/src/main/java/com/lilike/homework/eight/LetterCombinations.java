package com.lilike.homework.eight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *  电话号码与字母的组合
 * @Author llk
 * @Date 2020/8/14 16:47
 * @Version 1.0
 */
public class LetterCombinations {

    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        _letterCombinations(digits,0,"");
        return result;
    }


    /**
     * 用的是回溯法,严格遵守递归的代码模板
     * @param digits
     * @param i
     * @param s
     */
    private void _letterCombinations(String digits, int i, String s ) {

        // terminator
        if (s.length() == digits.length()) {
            result.add(s);
            return;
        }

        // process current logic
        String phoneLetter = phone.get(digits.charAt(i) + "");

        for (int j = 0; j < phoneLetter.length(); j++) {
            s += phoneLetter.charAt(j);
            // drill down
            _letterCombinations(digits,i+1,s);
            s = s.substring(0,s.length()-1);
        }

        // revert

    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinations().letterCombinations("23"));
    }

}
