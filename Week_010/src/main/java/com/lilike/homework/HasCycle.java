package com.lilike.homework;

/**
 *  环形链表
 *  https://leetcode-cn.com/problems/linked-list-cycle/
 * @Author llk
 * @Date 2020/10/10 17:11
 * @Version 1.0
 */
public class HasCycle {

    /**
     * 环形链表问题,使用快慢指针即可
     *  慢指针每次只走1步
     *      快指针每次走2步
     *   如果是环形,那么他们一定会相遇
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

}
