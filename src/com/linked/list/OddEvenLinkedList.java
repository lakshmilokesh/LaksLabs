package com.linked.list;

/**
 * Created by Laks on 2/2/16.
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking
 * about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null || head.next.next == null)
            return head;
        ListNode dummyOddHead = new ListNode(0,null);
        ListNode dummyEvenHead = new ListNode(0,null);
        dummyOddHead.next = head;
        dummyEvenHead.next = head.next;
        ListNode oddCur = head;
        ListNode evenCur = head.next;
        while (evenCur != null && evenCur.next != null) {
            oddCur.next = evenCur.next;
            evenCur.next = evenCur.next.next;
            oddCur = oddCur.next;
            evenCur = evenCur.next;
        }
        oddCur.next = dummyEvenHead.next;
        return dummyOddHead.next;
    }
}
