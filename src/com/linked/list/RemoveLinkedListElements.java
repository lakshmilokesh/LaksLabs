package com.linked.list;

/**
 * Created by Laks on 2/3/16.
 *
 * Question asked in Pure Storage online test : Feb 2016
 */
public class RemoveLinkedListElements {

    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0, null);
        helper.next = head;
        ListNode curr = helper;
        while (curr.next != null) {
            if (curr.next.getData() == val){
                curr.next = curr.next.next;
            }
            else {
                curr = curr.next;
            }
        }
        return helper.next;
    }
}
