package com.lilike.homework;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  排序链表
 *  https://leetcode-cn.com/problems/sort-list/
 * @Author llk
 * @Date 2020/10/12 20:59
 * @Version 1.0
 */
public class SortList {

    /***
     * 用堆的方式来实现
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));

        while (head != null) {
            pq.add(head);
            head=head.next;
        }

        ListNode dummy = new ListNode(1);
        ListNode newHead = pq.poll();
        dummy.next = newHead;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            poll.next = null;
            newHead.next = poll;
            newHead = newHead.next;
        }
        return dummy.next;

    }

    public static void main(String[] args) {

    }

}
