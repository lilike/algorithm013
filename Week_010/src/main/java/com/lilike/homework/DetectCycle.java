package com.lilike.homework;

/**
 *
 * 环形链表II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @Author llk
 * @Date 2020/10/10 17:15
 * @Version 1.0
 */
public class DetectCycle {

    /**
     * 如果是环,找到入环的那个节点
     *
     *      1. 首先判断有环,相遇的那个点
     *      2. 然后两个指针,一个指向开头,一个指向交汇点,用数学证明长度相同
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                // todo 找到环了,开始找交汇点
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
    }
}



