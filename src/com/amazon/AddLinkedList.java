package com.amazon;

import com.linked.list.LinkedList;
import com.linked.list.ListNode;

import java.io.IOException;
/*
 * You have 2 numbers represented by a linked list where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1's digit is on the head of the list.
 * Write a function to add 2 numbers and returns the sum as a linked list.
 * 
 * FOLLOW UP
 * 
 * Suppose the digits are stored in forward order, Repeat the above program.
 */
public class AddLinkedList extends LinkedList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Construct Node A");
		Node headA = createLinkedList();
		System.out.println("Construct Node B");
		Node headB = createLinkedList();
		
		displayValues(headA);
		displayValues(headB);
		
		Node finalNode = addLinkedList(headA, headB);
		displayValues(finalNode);
	}

	//Better coding
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0,null);
		ListNode current = dummyHead;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.data : 0;
			int y = (l2 != null) ? l2.data : 0;
			int sum = x + y + carry;
			carry = sum/10;

			current.next = new ListNode(sum%10,null);
			current = current.next;

			if (l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;

		}

		if (carry > 0) {
			current.next = new ListNode(carry,null);
		}
		return dummyHead.next;
	}
	
	private static Node addLinkedList(Node headA, Node headB) {
		
		int carry = 0, a = 0, b = 0, sum = 0;;
		Node currentA = headA;
		Node currentB = headB;
		Node finalNode = null;
		 
		int lenA = count(headA);
		int lenB = count(headB);
		int diff = lenA - lenB;
		if (diff < 0)
			diff = diff * -1;
		
		if(lenA < lenB) {
			padWithZero(headA,diff);
		}
		else if (lenA > lenB) {
			padWithZero(headB,diff);
		}
		
		displayValues(headA);
		displayValues(headB);
		
		while (currentA != null && currentB != null) {
			  a = Integer.parseInt(currentA.data);
			  b = Integer.parseInt(currentB.data);
			 sum = (a + b + carry)%10;	
			 carry = (a + b + carry)/10;
			 finalNode = constructSumNode(finalNode,sum);
			 currentA = currentA.next;
			 currentB = currentB.next;
		}
		if (carry > 0) { 
			finalNode = constructSumNode(finalNode,carry);
		}
		return finalNode;
	}
	
	private static void padWithZero(Node headA, int diff) {
		// TODO Auto-generated method stub
		Node current = headA;
		while (current.next != null) {
			current = current.next;			
		}
		while (diff > 0) {
			Node newNode = new LinkedList().new Node("0", null);
			current.next = newNode;
			current = current.next;
			diff--;
		}
	}

	private static Node constructSumNode(Node finalNode, int sum) {
		// TODO Auto-generated method stub
		Node current = finalNode;
		
		Node newNode = new LinkedList().new Node(new Integer(sum).toString(),null);
		if (finalNode == null) {
			finalNode = newNode;
			return finalNode;
		}
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
		return finalNode;
	}

}
