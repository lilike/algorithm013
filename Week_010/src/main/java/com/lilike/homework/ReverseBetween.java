package com.lilike.homework;

/**
 *  反转链表II
 *  https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * @Author llk
 * @Date 2020/10/12 16:07
 * @Version 1.0
 */
public class ReverseBetween {


    /**
     *  四个指针 , 一次遍历
     *      1. dummy : 记录开始头
     *      2. pre : 记录 start 开始的前一个节点
     *      3. start : 记录 m位置的节点
     *      4. then : 记录下一个需要反转的节点
     *
     *      eg: 1 -> 2 -> 3 -> 4 -> 5 -> NULL  m = 2 , n = 4
     *
     *          第一次遍历的属性如下:
     *
     *                  pre  start then
     *          dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *
     *         首先pre的位置是一直不变的
     *          然后每次把then塞到pre的后面
     *
     *          第一次循环操作
     *              dummy -> 1 -> 3 -> 2 -> 4 -> 5 -> NULL
     *
     *           第二次操作
     *              dummy -> 1 -> 4 -> 3 -> 2 -> 5 -> NULL
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy,start,then;
        for (int i = 0; i < m-1; i++) {
            pre = pre.next;
        }

        start = pre.next;
        then = start.next;

        for (int i = 0; i < n-m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }

}
