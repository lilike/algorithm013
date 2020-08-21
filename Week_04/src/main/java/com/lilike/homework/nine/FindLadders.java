package com.lilike.homework.nine;

import java.util.*;

/**
 * 单词接龙II
 * https://leetcode-cn.com/problems/word-ladder-ii/
 *
 * @Author llk
 * @Date 2020/8/20 13:49
 * @Version 1.0
 */
public class FindLadders {


    /**
     * 先用广度优先搜索的方式找到一个最短路径中,所有的节点的后继节点
     * 然后用深度优先搜索回溯的方式去找出所有的最短路径
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {



        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);

        if (!wordSet.contains(endWord)) {
            return new ArrayList<>();
        }

        Map<String, Set<String>> successor = new HashMap<>();

        // bfs

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int n = beginWord.length();

        boolean flag = false;
        Set<String> nextVisited = new HashSet<>();
        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {
                String wordToken = queue.poll();
                char[] tokenChar = wordToken.toCharArray();
                for (int i = 0; i < n; i++) {
                    char oldChar = tokenChar[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (oldChar == j) continue;
                        tokenChar[i] = j;
                        String newStr = new String(tokenChar);
                        if (!visited.contains(newStr)) {
                            if (wordSet.contains(newStr)) {
                                if (newStr.equals(endWord)) {
                                    flag = true;
                                }

                                if (!nextVisited.contains(newStr)) {
                                    nextVisited.add(newStr);
                                    queue.add(newStr);
                                }

                                // 添加successor
                                Set<String> set = successor.getOrDefault(wordToken, new HashSet<>());
                                set.add(newStr);
                                successor.put(wordToken, set);
                            }
                        }

                    }
                    tokenChar[i] = oldChar;
                }
            }
            if (flag) break;
            visited.addAll(nextVisited);
            nextVisited.clear();
        }

        System.out.println(successor);

        List<List<String>> result = new ArrayList<>();

        LinkedList<String> path = new LinkedList<>();
        path.addLast(beginWord);
        dfs(beginWord,endWord,successor,path,result);

        return result;
    }

    private void dfs(String beginWord, String endWord, Map<String, Set<String>> successor, LinkedList<String> path, List<List<String>> result) {

        // terminator
        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(path));
            return;
        }

        // process current logic
        System.out.println("beginWord--->" + beginWord );
        Set<String> beginSet = successor.get(beginWord);
        if (beginSet == null) return;

        for (String s : beginSet) {
            path.addLast(s);
            dfs(s,endWord,successor,path,result);
            path.removeLast();
        }

    }


    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] wordListArray = new String[]{"hot","dot","dog","lot","log","cog"};
        Collections.addAll(wordList, wordListArray);
        FindLadders solution = new FindLadders();
        List<List<String>> result = solution.findLadders(beginWord, endWord, wordList);
        System.out.println(result);

    }

}


