package com.lilike.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * 单词搜索II
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * @Author llk
 * @Date 2020/10/7 20:05
 * @Version 1.0
 */
public class FindWords {

    /**
     * 使用 回溯 算法 + 字典树来实现
     * 首先你把单词存入到字典树里面
     * 然后开始在矩阵里面进行回溯算法
     * 如果遇到能够匹配的,就直接进行添加
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        MyTrie myTrie = new MyTrie();
        for (int i = 0; i < words.length; i++) {
            myTrie.insert(words[i]);
        }

        // 开始进行回溯算法
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String s = "";
                if (myTrie.startWith(s)) {
                    dfs(result, i, j, board, s,myTrie);
                }

            }
        }

        return result;
    }

    private void dfs(List<String> result, int i, int j, char[][] board, String s, MyTrie myTrie) {
        // terminator
        int nc = board.length;
        int nr = board[0].length;

        if (i < 0 || j < 0 || i > nc - 1 || j > nr - 1) {
            return;
        }

        // process current logic and drill down
        if (board[i][j] == '$') return;

        // drill down
        if (myTrie.startWith(s)) {
            char temp = board[i][j];
            s =  s + board[i][j];
            if (myTrie.search(s) && !result.contains(s)) result.add(s);
            board[i][j] = '$';
            dfs(result,i+1,j,board,s,myTrie);
            dfs(result,i,j+1,board,s,myTrie);
            dfs(result,i-1,j,board,s,myTrie);
            dfs(result,i,j-1,board,s,myTrie);
            board[i][j] = temp;
        }

    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'o','a','a','n'},
                                      {'e','t','a','e'},
                                      {'i','h','k','r'},
                                      {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};

        FindWords findWords = new FindWords();
        System.out.println(findWords.findWords(board,words));

    }

}


@SuppressWarnings("ALL")
class MyTrie {

    MyTrie[] next;
    boolean isEnd;

    public MyTrie() {
        this.next = new MyTrie[26];
        this.isEnd = false;
    }

    public boolean search(String s) {
        MyTrie root = this;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (root.next[idx] == null) return false;
            root = root.next[idx];
        }
        return root.isEnd;
    }

    public void insert(String s) {
        MyTrie root = this;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (root.next[idx] == null) root.next[idx] = new MyTrie();
            root = root.next[idx];
        }
        root.isEnd = true;
    }

    public boolean startWith(String s) {
        MyTrie root = this;

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (root.next[idx] == null) return false;
            root = root.next[idx];
        }
        return true;
    }


}

