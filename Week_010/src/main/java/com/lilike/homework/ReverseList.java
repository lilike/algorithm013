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
     *  首先使用迭代的的方式进行处理
     *      分别需要三个指针
     *          head next newHead
     *          newHead 初始化为 null
     *
     *          ListNode next = head.next;
     *          head.next = newHead;
     *          newHead = head;
     *          head = next;
     *
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;

    }

    /**
     * 递归的操作更加简单
     * @param head
     * @return
     */
    public ListNode reverseListRecursion(ListNode head) {
        return dg(head,null);
    }

    private ListNode dg(ListNode head, ListNode newHead) {
        if (head == null) return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return dg(next,head);
    }

    public static void main(String[] args) {

        ListNode l5 = new ListNode(1);
        ListNode l4 = new ListNode(4,l5);
        ListNode l3 = new ListNode(3,l4);
        ListNode l2 = new ListNode(2,l3);
        ListNode l1 = new ListNode(1,l2);

        System.out.println(new ReverseList().reverseListRecursion(l1).val);

    }


}
