package com.lilike.nov;

import com.lilike.homework.ListNode;

/**
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * 对链表进行插入排序
 *
 * @Author llk
 * @Date 2020/11/20 11:32
 * @Version 1.0
 */
public class InsertionSortList {

    /**
     * 需要4个指针才可以解决这个问题 分别是 lastStored  dummy curr pre
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode lastStored = head, curr = head.next;
        while (curr != null) {
            if (lastStored.val <= curr.val) {
                lastStored = curr;
            }else {
                ListNode pre = dummy;
                while (pre.next.val <= curr.val) {
                    pre = pre.next;
                }
                lastStored.next = curr.next;
                curr.next = pre.next;
                pre.next = curr;
            }
            curr = lastStored.next;
        }
        return dummy.next;
    }

}


