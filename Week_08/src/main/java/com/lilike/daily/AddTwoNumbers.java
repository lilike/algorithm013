package com.lilike.daily;

/**
 * 两个数相加
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @Author llk
 * @Date 2020/9/20 11:20
 * @Version 1.0
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(-1);
        ListNode res = ans;

        boolean nextPlusOne = false;
        while (l1 != null || l2 != null) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            int result = l1Val + l2Val;
            if (nextPlusOne) {
                result += 1;
                nextPlusOne = false;
            }
            if (result < 10) {
                res.next = new ListNode(result);
            } else {
                res.next = new ListNode(result % 10);
                nextPlusOne = true;
            }
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
            res = res.next;
        }

        if (l1 == null && l2 == null) {
            if (nextPlusOne) {
                res.next = new ListNode(1);
            }
        }
        return ans.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l1.next = l3;

        ListNode l2 = new ListNode(1);

        new AddTwoNumbers().addTwoNumbers(l1,l2);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
