package com.lilike.homework;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形列表
 *  https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @file HasCycle.java
 * @author lyric
 * @date 2020/7/31
 */
public class HasCycle {

    public static void main(String[] args) {


    }


    public boolean solution2(ListNode head) {

        Set<ListNode> sets = new HashSet<>();

        while (head != null) {
            if (sets.contains(head)) {
                return true;
            }else {
                sets.add(head);
            }
            head = head.next;
        }
        return false;
    }





    /**
     * 两个指针 快和慢
     *  如果出现了相遇就表示是环形链表
     * @param head
     * @return
     */
    public boolean solution(ListNode head) {

        if (head == null ) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (first != null && second != null) {
            if (first == second) {
                return true;
            }
            first = first.next;
            if (second.next == null) {
                return false;
            }else {
                second = second.next.next;
            }
        }
        return false;
    }


}
