package com.lilike.nov;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 *
 * @Author llk
 * @Date 2020/11/5 8:46
 * @Version 1.0
 */
public class LadderLength {

    /**
     * 使用双向BFS实现
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int ans = 1;
        wordList.remove(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();

        Set<String> visited = new HashSet<>();

        beginSet.add(beginWord);
        endSet.add(endWord);


        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (endSet.size() > beginSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextSet = new HashSet<>();

            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        chars[i] = j;

                        String str = new String(chars);

                        if (endSet.contains(str)) {
                            return ans + 1;
                        }

                        if (!visited.contains(str) && wordSet.contains(str)) {
                            visited.add(str);
                            nextSet.add(str);
                        }
                    }
                    chars[i] = old;
                }

            }

            ans++;
            beginSet = nextSet;
        }
        return 0;
    }


}
