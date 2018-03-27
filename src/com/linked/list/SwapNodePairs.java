package com.linked.list;

/*
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1􏰀2􏰀3􏰀4, you should return the list as 2􏰀1􏰀4􏰀3.
 * Your algorithm should use only constant space. You may not modify the values in the list,
 * only nodes itself can be changed.
 * Example Questions Candidate Might Ask:
 * Q: What if the number of nodes in the linked list has only odd number of nodes?
 * A: The last node should not be swapped.
 *  
 */
public class SwapNodePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//Iterative approach : 0(1) space
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode helper = new ListNode(0,null);
		helper.next = head;

		ListNode pre = helper;
		ListNode cur = pre.next;

		while (cur != null && cur.next != null) {
			pre.next = cur.next;
			cur.next = cur.next.next;
			pre.next.next = cur;

			pre = cur;
			cur = pre.next;
		}

		return helper.next;
	}


	//Recursive approach :  recursive stack uses O(n) space
	public ListNode swapPairsRec(ListNode head) {
		if ((head == null)||(head.next == null))
			return head;
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

}
