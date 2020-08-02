package com.lilike.homework;

/***
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 *
 * @file ReverseList.java
 * @author lyric
 * @date 2020/7/29
 */
public class ReverseList {

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * @param args
     */
    public static void main(String[] args) {





    }


    /**
     * 迭代法:
     *   遍历,然后直接反转
     *
     *
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }


        return prev;
    }


    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode solution2(ListNode head) {

        if (head.next == null || head == null){
            return head;
        }

        ListNode cur = solution2(head.next);

        head.next.next = head;
        head.next = null;
        return cur;
    }
}
