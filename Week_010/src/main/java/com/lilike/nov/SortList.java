package com.lilike.nov;

import com.lilike.homework.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  https://leetcode-cn.com/problems/sort-list/
 *  排序链表
 * @Author llk
 * @Date 2020/11/21 9:16
 * @Version 1.0
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        // 使用小根堆实现
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        while (head != null) {
            pq.add(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(-1);
        ListNode h = dummy;
        while (!pq.isEmpty()) {
            h.next = pq.poll();
            h = h.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        pq.add(3);
        pq.add(1);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

    }

}
