package com.lilike.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author llk
 * @Date 2020/8/6 11:07
 * @Version 1.0
 */
public class FizzBuzz {

    public static void main(String[] args) {

        System.out.println(new FizzBuzz().fizzBuzz(15));


    }

    /**
     * 暴力
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            }else if (i % 3 == 0 && i % 5 > 0) {
                result.add("Fizz");
            }
            else if (i % 3 > 0 && i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i + "");
            }
        }
        return result;
    }


}
