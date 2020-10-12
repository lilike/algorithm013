package com.lilike.homework;

/**
 * @Author llk
 * @Date 2020/10/9 17:15
 * @Version 1.0
 */
public class ListNode {

    int val;
    ListNode next;
    ListNode() {};

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
