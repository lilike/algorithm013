package com.lilike.homework;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * @Author llk
 * @Date 2020/9/12 9:52
 * @Version 1.0
 */
public class LadderLength {

    /**
     * 双向BFS
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 返回结果,总步长
        int ladderLength = 1;

        // 为了让查询时间复杂度是O(1)
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // 其实就是BFS的队列
        Set<String> beginSet = new HashSet<>(), endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);


        // 记录已经访问过的单词
        Set<String> visited = new HashSet<>();

        while (beginSet.size() > 0 && endSet.size() > 0) {

            // 优先从较小的地方进行扩散
            if (beginSet.size() > endSet.size())  {
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }

            Set<String> nextVisited = new HashSet<>();

            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < word.length(); i++) {
                    for (char j = 'a'; j <= 'z' ; j++) {
                        char tempChar = wordChars[i];
                        wordChars[i] = j;
                        String newWords = new String(wordChars);
                        if (endSet.contains(newWords)) {
                            return ladderLength + 1;
                        }
                        if (!visited.contains(newWords) && wordSet.contains(newWords)) {
                            nextVisited.add(newWords);
                            visited.add(newWords);
                        }
                        wordChars[i] = tempChar;
                    }
                }
            }
            ladderLength++;
            beginSet = nextVisited;

        }
        return 0;
    }

    public static void main(String[] args) {

    }


}
