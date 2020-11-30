package com.lilike.homework;

/**
 *
 *  链表中倒数第k个节点
 *  https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @Author llk
 * @Date 2020/10/13 16:30
 * @Version 1.0
 */
public class getKthFromEnd {

    /**
     * 链表中的第 k 个节点,使用快慢指针来实现
     *
     *          1 -> 2 -> 3 -> 4 -> 5
     *
     *          lenth = 5
     *          5-k+1
     *
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {

        int l = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        while (fast.next != null) {
            fast = fast.next;
            l++;
        }

        for (int i = 0; i < l-k+1; i++) {
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {

    }

}
