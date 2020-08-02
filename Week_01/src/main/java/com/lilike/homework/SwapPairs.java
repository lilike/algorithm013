package com.lilike.homework;

/**
 *  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 *  两两交换链表中的节点
 *
 * @file SwapPairs.java
 * @author lyric
 * @date 2020/7/29
 */
public class SwapPairs {

    public static void main(String[] args) {

    }


    /**
     *  1 -> 2 -> 3 -> 4
     *  1 -> 2 -> 3 <- 4
     *  2 -> 1 -> 4 -> 3
     *
     *
     * 递归的解法
     * 递归是什么?
     *  递归就好像是溯源.
     *      我们在电影院黑漆漆的,不知道自己在第几排,就问前面一排的你们在第几排啊,他们也不知道,于是也问前面的,直到问道第一排,然后第一排告诉后面的人
     *      ,后面的人就知道自己第几排了,然后告诉自己后面的人,以此类推.
     * @param head
     * @return
     */
    public ListNode solution1(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode firstNode = head;
        ListNode secondNode = head.next;

        ListNode res = solution1(secondNode.next);

        secondNode.next = firstNode;
        firstNode.next = res;

        return secondNode;


    }

}
