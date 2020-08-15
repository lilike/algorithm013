package com.lilike.daily;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author llk
 * @Date 2020/8/12 11:01
 * @Version 1.0
 */
public class ReversePrint {


    public int[] reversePrint2(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int i = 0;
        int[] r = new int[stack.size()];
        while (!stack.empty()) {
            r[i++] = stack.pop();
        }
        return r;

    }


    /**
     * 思路1 : 遍历输入到数组,然后将数组反转
     * 思路2 : 遍历输入到栈,然后直接遍历栈即可
     * @param head
     * @return
     */
    public int[] reversePrint1(ListNode head) {

        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0,j=result.length-1; i < j; i++,j--) {
            int temp = result[i];
            result[i] = result[j];
            result[j] = temp;
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);

        n1.next = n2;
        n2.next = n3;

        System.out.println(Arrays.toString(new ReversePrint().reversePrint2(n1)));

    }


}
