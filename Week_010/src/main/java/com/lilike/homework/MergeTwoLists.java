package com.lilike.homework;

/**
 * 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @Author llk
 * @Date 2020/10/9 17:16
 * @Version 1.0
 */
public class MergeTwoLists {

    /**
     * 链表一般用双指针问题来解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (l1 != null && l2 != null) {
            int v1 = l1.val;
            int v2 = l2.val;
            root.next = v1 < v2 ? l1 : l2;
            if (v1 < v2) {
                l1 = l1.next;
            }else {
                l2 = l2.next;
            }
            root = root.next;
        }
        if (l1 != null) root.next = l1;
        if (l2 != null) root.next = l2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l14 = new ListNode(4);
        ListNode l12 = new ListNode(2,l14);
        ListNode l1 = new ListNode(1,l12);

        ListNode l24 = new ListNode(4);
        ListNode l23 = new ListNode(3,l24);
        ListNode l2 = new ListNode(1,l23);

        System.out.println(new MergeTwoLists().mergeTwoLists(l1,l2));
    }



}
