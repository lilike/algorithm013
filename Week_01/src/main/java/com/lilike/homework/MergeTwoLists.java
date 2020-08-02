package com.lilike.homework;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 合并两个链表
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * @author lyric
 * @file MergeTwoLists.java
 * @date 2020/7/31
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }


    /**
     * 使用递归
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = solution2(l1.next,l2);
            return l1;
        }else {
            l2.next = solution2(l1,l2.next);
            return l2;
        }
    }



    /**
     * 思路 : 双指针 分别向后面移动,如果出现小的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode solution1(ListNode l1, ListNode l2) {

        ListNode preHead = new ListNode(-1);

        ListNode pre = preHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;

            } else {
                pre.next = l2;
                l2 = l2.next;
            }
        }
        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

}
