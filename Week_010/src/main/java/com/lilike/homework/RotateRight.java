package com.lilike.homework;

/**
 * 链表旋转
 * https://leetcode-cn.com/problems/rotate-list/
 *
 * @Author llk
 * @Date 2020/10/12 16:58
 * @Version 1.0
 */
public class RotateRight {


    /***
     *   假设是
     *
     *   dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> NULL
     *
     *
     *   反转两次
     *
     *   dummy -> 4 -> 5 -> 1 -> 2 -> 3
     *
     *   假设链表的长度是 l
     *       那么就是走到 l - k + 1  的位置 是新的 head
     *
     *       两个指针,一个是fast 指向最后一个数 5
     *       另外一个是 slow ,指向 4
     *
     *       首先计算出长度,然后取%
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy,slow = dummy;

        int count = 0 ;
        while (fast.next != null) {
            count++;
            fast = fast.next;
        }

        k = k % count;

        for (int i = 0; i < count - k ; i++) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }


}
