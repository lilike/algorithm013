package com.lilike.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author llk
 * @Date 2020/9/8 19:47
 * @Version 1.0
 */
public class FindWords {

    public List<String> findWords(char[][] board, String[] words) {

        // 插入这一块 length * words.length
        Set<String> result = new HashSet<String>();
        MyTrie myTrie = new MyTrie();
        for (int i = 0; i < words.length; i++) {
            myTrie.insertMyTrie(words[i]);
        }

        int nr = board.length;
        int nc = board[0].length;

        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                String s = board[i][j] + "";
                if (myTrie.startsWith(s)) {
                    dfs(myTrie, board, i, j, result, "");
                }
            }
        }
        return new ArrayList<String>(result);
    }

    private void dfs(MyTrie myTrie, char[][] board, int i, int j, Set<String> result, String str) {
        int nr = board.length - 1;
        int nc = board[0].length - 1;


        // terminator
        if (i < 0 || i > nr || j < 0 || j > nc) {
            return;
        }

        if (board[i][j] == '$') return;

        String s = str + board[i][j];


        if (myTrie.search(s)) {
            result.add(s);
        }

        if (myTrie.startsWith(s)) {
            char temp = board[i][j];
            board[i][j] = '$';
            dfs(myTrie, board, i - 1, j, result, s);
            dfs(myTrie, board, i, j - 1, result, s);
            dfs(myTrie, board, i + 1, j, result, s);
            dfs(myTrie, board, i, j + 1, result, s);
            board[i][j] = temp;
        }
    }

    public static void main(String[] args) {

        String[] words = {"oath","pea","eat","rain"};
        char[][] boards = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };

        System.out.println(new FindWords().findWords(boards,words));

    }

}


class MyTrie {

    MyTrie[] next;
    boolean isEnd;

    public MyTrie() {
        next = new MyTrie[27];
        this.isEnd = false;
    }

    public void insertMyTrie(String str) {

        MyTrie root = this;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (root.next[index] == null) root.next[index] = new MyTrie();
            root = root.next[index];
        }
        root.isEnd = true;
    }

    public boolean search(String str) {
        MyTrie root = this;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            MyTrie myTrie = root.next[index];
            if (myTrie == null) return false;
            root = myTrie;
        }
        return root.isEnd;
    }


    public boolean startsWith(String prefix) {
        MyTrie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            MyTrie myTrie = root.next[index];
            if (myTrie == null) return false;
            root = myTrie;
        }
        return true;
    }


}