package com.GoogleLessFrequent;

/*
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example:
Input:
1->2->3

Output:
1->2->4
 *
 *
 *
 */

import com.linked.list.ListNode;

public class PlusOneLinkedList {

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1, null);
        ListNode n2 = new ListNode(2, null);
        ListNode n3 = new ListNode(9, null);
        ListNode n4 = new ListNode(0, null);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode r = plusOne(n1);

        while (r != null) {
            System.out.println(r.data);
        }


    }

    public static ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.data != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit

        i.data++;
        i = i.next;
        while (i != null) {
            i.data = 0;
            i = i.next;
        }

        if (dummy.data == 0) return dummy.next;
        return dummy;
    }
}
