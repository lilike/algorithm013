package com.lilike.homework;

/**
 * 字典树
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @Author llk
 * @Date 2020/9/7 21:08
 * @Version 1.0
 */
public class Trie {

    TrieNode node;

    public Trie() {
        node = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode root = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            TrieNode next = root.next[index];
            if (next == null) root.next[index] = new TrieNode();
            root = root.next[index];
        }
        root.setEnd(true);

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode root = this.node;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            TrieNode trieNode = root.next[index];
            if (trieNode == null) return false;
            root = trieNode;
        }
        return root.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        TrieNode root = this.node;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            TrieNode trieNode = root.next[index];
            if (trieNode == null) return false;
            root = trieNode;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("aaa");

        System.out.println(trie.search("a"));
    }


}

class TrieNode {

    TrieNode[] next;
    boolean isEnd = false;

    public TrieNode() {
        this.next = new TrieNode[26];
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
