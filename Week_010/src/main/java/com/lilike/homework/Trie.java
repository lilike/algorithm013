package com.lilike.homework;

/**
 *  字典树 前缀树
 * @Author llk
 * @Date 2020/10/7 18:40
 * @Version 1.0
 */
class Trie {

    Trie[] next;
    boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        this.next = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.next[idx] == null) root.next[idx] = new Trie();
            root = root.next[idx];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (root.next[idx] == null) return false;
            root = root.next[idx];
        }
        return root.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root = this;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (root.next[idx] == null) return false;
            root = root.next[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */