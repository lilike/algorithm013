package com.lilike.homework;

import javax.swing.text.html.parser.Entity;
import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author llk
 * @Date 2020/9/15 22:06
 * @Version 1.0
 */
class LRUCache {

    /**
     * 实现的思路就是 链表来实现
     *
     * 同时使用一个HashMap来作为缓存快速查询
     *
     * 使用双向链表来作为 最近最少使用的淘汰的方法
     * @param capacity
     */

    // 作为缓存使用
    Map<Integer,Entry> cache ;

    int size;

    int capacity;

    Entry head;

    Entry tail;

    public LRUCache(int capacity) {

        this.capacity = capacity;
        this.size = 0;
        cache = new HashMap<>(capacity);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Entry node = cache.get(key);
        if ( node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Entry node = cache.get(key);
        // 如果不存在
        if (node == null) {
            // 首先创建
            node = new Entry(key,value);
            // 把这个放到头结点里面
            addToHead(node);
            size ++;
            if (size > capacity) {
                removeTail();
                size--;
            }
        }else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void moveToHead(Entry node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeTail() {
        removeNode(tail.pre);

    }

    private void removeNode(Entry node) {
        cache.remove(node.key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Entry node) {
        cache.put(node.key,node);
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }


    static class Entry {

        int key;
        int value;
        Entry pre;
        Entry next;

        public Entry() {
        }

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        // ["LRUCache","put","put","get","put","put","get"]
        //[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // 返回  1
        cache.put(1, 1);    // 该操作会使得关键字 2 作废
        cache.put(4, 1);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)


    }

}
