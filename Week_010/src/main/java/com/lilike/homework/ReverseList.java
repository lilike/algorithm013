package com.lilike.homework;

import java.util.Stack;

/**
 *  反转链表 这个除了使用迭代还可以使用递归
 *  https://leetcode-cn.com/problems/reverse-linked-list/
 * @Author llk
 * @Date 2020/10/10 17:23
 * @Version 1.0
 */
public class ReverseList {

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode pop = stack.pop();
        ListNode h = pop;
        while (!stack.isEmpty()) {
            h.next = stack.pop();
            h = h.next;
        }
        h.next = null;
        return pop;
    }




}
