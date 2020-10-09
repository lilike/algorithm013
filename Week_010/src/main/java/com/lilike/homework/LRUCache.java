package com.lilike.homework;

import java.util.HashMap;
import java.util.Map;

/**
 *  LRU缓存机制
 *      就是最近最少使用淘汰机制
 *
 *
 *  https://leetcode-cn.com/problems/lru-cache/
 * @Author llk
 * @Date 2020/10/7 14:15
 * @Version 1.0
 */
public class LRUCache {

    Map<Integer,Entry> cache;

    int capacity;

    int size = 0;

    Entry head;

    Entry tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        head = new Entry();
        tail = new Entry();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Entry entry = cache.get(key);
        if (entry != null) {
            moveToHead(entry);
            return entry.value;
        }
        return -1;
    }

    /**
     * 移动到头部
     * @param entry
     */
    private void moveToHead(Entry entry) {
        removeEntry(entry);
        addToHead(entry);
    }

    private void addToHead(Entry entry) {
        head.next.pre = entry;
        entry.next = head.next;
        entry.pre = head;
        head.next = entry;
        size++;
    }

    private void removeEntry(Entry entry) {
        entry.next.pre = entry.pre;
        entry.pre.next = entry.next;
        size--;
    }

    public void put(int key, int value) {
        Entry entry = cache.get(key);
        if (entry == null) {
            entry = new Entry(key,value);
            cache.put(key,entry);
            addToHead(entry);
            if (size > capacity) {
                cache.remove(tail.pre.key);
                removeEntry(tail.pre);

            }

        }else {
          entry.value = value;
          moveToHead(entry);
        }

    }


    class Entry {

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

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));;
        cache.put(4,4);
        System.out.println(cache.get(1));;
        System.out.println(cache.get(3));;
        System.out.println(cache.get(4));;

    }

}
