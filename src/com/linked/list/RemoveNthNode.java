package com.linked.list;

/**
 * Created by Laks on 2/2/16.
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 */
public class RemoveNthNode {

    public static void main(String[] args) {

    }
    public static ListNode removeNthNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0, null);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        int count = 0;
        while(p.next != null){
            if(count >= n)
                q = q.next;
            p = p.next;
            count++;
        }
        if(q.next != null)
            q.next = q.next.next;
        return dummy.next;
    }
}
