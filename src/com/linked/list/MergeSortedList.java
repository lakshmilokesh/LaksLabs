package com.linked.list;

/*
 * Merge two sorted linked lists and return it as a new list. The new list should be made 
 * by splicing together the nodes of the first two lists.
 * 
 */
public class MergeSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode p = dummyHead;
        while (l1 != null && l2 != null) {
        	if (l1.data < l2.data) {
        		p.next = l1;
        		l1 = l1.next;
        	}
        	else {
        		p.next = l2;
        		l2 = l2.next;
        	}
        	p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyHead.next;
        
    }    
}
