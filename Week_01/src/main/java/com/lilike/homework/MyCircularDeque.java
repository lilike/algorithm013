package com.lilike.homework;


/**
 *  https://leetcode-cn.com/problems/design-circular-deque/
 *   设计循环双端队列
 * @file MyCircularDeque.java
 * @author lyric
 * @date 2020/8/2
 */
public class MyCircularDeque {

    private int sizeMax;

    private ListNode head;

    private ListNode tail;

    private int size;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        sizeMax = k;
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if (size + 1 > sizeMax) {
            return false;
        }

        ListNode listNode = new ListNode(value);

        ListNode temp = head.next;
        head.next = listNode;
        listNode.next = temp;
        temp.prev = listNode;
        listNode.prev = head;
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {

        if (size + 1 > sizeMax) {
            return false;
        }


        ListNode listNode = new ListNode(value);

        ListNode temp = tail.prev;;

        tail.prev = listNode;
        listNode.next = tail;
        temp.next = listNode;
        listNode.prev = temp;
        size ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        ListNode temp = head.next.next;

        head.next = temp;
        temp.prev = head;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {

        if (size == 0) {
            return false;
        }

        ListNode temp = tail.prev.prev;
        temp.next = tail;
        tail.prev = temp;
        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return head.next.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return tail.prev.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size >= sizeMax;
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));			        // 返回 true
        System.out.println(circularDeque.insertLast(2));			        // 返回 true
        System.out.println(circularDeque.insertFront(3));			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 已经满了，返回 false
        System.out.println(circularDeque.getRear());  				// 返回 2
        System.out.println(circularDeque.isFull());				        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.insertFront(4));			        // 返回 true
        System.out.println(circularDeque.getFront());				// 返回 4
    }

}

