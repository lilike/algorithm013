package com.lilike.homework;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @Author llk
 * @Date 2020/10/8 15:47
 * @Version 1.0
 */
public class LadderLength {

    /**
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 这道题目要使用双向BFS来进行解决
     * <p>
     * 从beginword开始每个字母开始扩散
     * 如果遇到存在字典里面的,那么就直接加入到队列中,相当于是BFS
     * 但是我采用双向的,
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int ans = 1;


        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        Set<String> beginQueue = new HashSet<>();
        Set<String> endQueue = new HashSet<>();

        Set<String> visited = new HashSet<>();

        beginQueue.add(beginWord);
        endQueue.add(endWord);

        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            // 比较大小
            if (beginQueue.size() > endQueue.size()) {
                Set<String> temp = endQueue;
                endQueue = beginQueue;
                beginQueue = temp;

            }

            Set<String> nextQueue = new HashSet<>();
            for (String s : beginQueue) {
                char[] wordChars = s.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char temp = wordChars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        wordChars[i] = j;
                        String str = new String(wordChars);
                        if (wordSet.contains(str)) {
                            if (endQueue.contains(str)) {
                                return ans + 1;
                            }

                            if (!visited.contains(str) && wordSet.contains(str)) {
                                nextQueue.add(str);
                                visited.add(str);
                            }

                        }
                    }
                    wordChars[i] = temp;

                }
            }
            ans++;
            beginQueue = nextQueue;
        }

        return 0;

    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new LadderLength().ladderLength(beginWord,endWord,Arrays.asList(wordList)));
    }

}
