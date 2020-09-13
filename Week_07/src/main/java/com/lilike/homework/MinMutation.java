package com.lilike.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 基因序列
 * https://leetcode-cn.com/problems/minimum-genetic-mutation/
 * @Author llk
 * @Date 2020/9/12 10:19
 * @Version 1.0
 */
@SuppressWarnings("ALL")
public class MinMutation {


    /**
     * 可以双向BFS
     *
     * "A", "C", "G", "T"
     * @param start
     * @param end
     * @param bank
     * @return
     */
    public int minMutation(String start, String end, String[] bank) {

        int minMutation = 0;
        Set<String> bankSet = new HashSet(Arrays.asList(bank));
        bankSet.remove(start);

        char[] wordChars = {'A', 'C', 'G', 'T'};
        Set<String> beginSet = new HashSet<>(),endSet = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);

        if (!bankSet.contains(end)) return -1;

        Set<String> visited = new HashSet<>();

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextVisted = new HashSet<>();
            if (beginSet.size() > endSet.size() ) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char oldChar = chars[i];
                    for (int j = 0; j < wordChars.length; j++) {
                        chars[i] = wordChars[j];
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            return minMutation+1;
                        }
                        if (!visited.contains(newWord) && bankSet.contains(newWord)) {
                            visited.add(newWord);
                            nextVisted.add(newWord);
                        }
                    }
                    chars[i] = oldChar;
                }
            }
            minMutation++;
            beginSet = nextVisted;
        }
        return -1;
    }


    public static void main(String[] args) {

        String begin = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        System.out.println(new MinMutation().minMutation(begin,end,bank));


    }
}
