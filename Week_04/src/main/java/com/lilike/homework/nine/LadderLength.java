package com.lilike.homework.nine;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/description/
 * 单词接龙
 *
 * @Author llk
 * @Date 2020/8/17 16:47
 * @Version 1.0
 */

public class LadderLength {


    /**
     * 双向广度优先遍历,两边都朝着中间进行遍历,这样时间更少
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        if (!wordSet.contains(endWord)) return 0;


        Set<String> visited = new HashSet<>();

        Set<String> beginVisited = new HashSet<>();
        beginVisited.add(beginWord);

        Set<String> endVisited = new HashSet<>();
        endVisited.add(endWord);

        int step = 1;

        while (beginVisited.size() > 0 && endVisited.size() > 0) {

             System.out.println("beginVisited => " + beginVisited);
             System.out.println("  endVisited => " + endVisited + "\n");

            // 从较小的层进行开始扩散

            if (beginVisited.size() > endVisited.size()) {
                Set<String> temp = beginVisited;
                beginVisited = endVisited;
                endVisited = temp;
            }

            Set<String> nextVisited = new HashSet<>();
            for (String s : beginVisited) {
                char[] tokenChar = s.toCharArray();

                for (int i = 0; i < tokenChar.length; i++) {
                    char oldChar = tokenChar[i];

                    for (char j = 'a'; j <= 'z'; j++) {
                        if (oldChar == j) continue;
                        tokenChar[i] = j;
                        String newStr = new String(tokenChar);
                        if (wordSet.contains(newStr)) {
                            if (endVisited.contains(newStr)) {
                                return step + 1;
                            }

                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                nextVisited.add(newStr);
                            }

                        }

                    }
                    tokenChar[i] = oldChar;
                }
            }
            beginVisited = nextVisited;
            step++;

        }


        return 0;
    }


    /**
     * 首先是广度优先遍历
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 转为set,因为set的精确匹配时间复杂度是O(1)

        Set<String> wordSet = new HashSet<>(wordList);
        wordList.remove(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // BFS必备
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int step = 1; // 一开始就是第一步
        while (queue.size() > 0) {
            // 层序遍历.按层扩展
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String token = queue.poll();

                char[] tokenChars = token.toCharArray();

                for (int j = 0; j < tokenChars.length; j++) {
                    // 记录当前的char
                    char oldChar = tokenChars[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == oldChar) continue;
                        ;
                        tokenChars[j] = k;
                        // 新的字符串
                        String newStr = new String(tokenChars);
                        if (wordSet.contains(newStr)) {
                            if (newStr.equals(endWord)) {
                                return step + 1;
                            }

                            if (!visited.contains(newStr)) {
                                visited.add(newStr);
                                queue.add(newStr);
                            }

                        }
                    }
                    // 还原字符
                    tokenChars[j] = oldChar;
                }
            }
            step++;
        }
        return 0;
    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] wordListArray = new String[]{"hot","dot","dog","lot","log"};
        Collections.addAll(wordList, wordListArray);
        LadderLength solution = new LadderLength();
        int res = solution.ladderLength2(beginWord, endWord, wordList);
        System.out.println(res);

    }

}

