package com.lilike.homework;

/**
 *  两两交换链表中的节点
 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @Author llk
 * @Date 2020/10/13 16:39
 * @Version 1.0
 */
public class SwapPairs {

    /**
     *  调转之后, 有一个 newHead
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;

        return n;
    }

    public static void main(String[] args) {

    }


}
