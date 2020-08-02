package com.lilike.homework;

import java.awt.print.Pageable;

public class DetectCycle {

    public static void main(String[] args) {


    }

    public ListNode solution1(ListNode head) {

        // 首先是找到交汇点
        ListNode jh = findJhPoint(head);
        if (jh == null) {
            return jh;
        }

        while (head != jh) {
            head = head.next;
            jh = jh.next;
        }
        return head;
    }

    private ListNode findJhPoint(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }else {
                fast = fast.next.next;
            }
            if (fast == slow) {
                return fast;
            }
        }



        return null;
    }


}
