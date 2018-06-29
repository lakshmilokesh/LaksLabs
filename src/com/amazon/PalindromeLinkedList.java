package com.amazon;

import java.io.IOException;
import java.util.Stack;

import com.linked.list.LinkedList;
import com.linked.list.LinkedList.Node;

/*
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 */

public class PalindromeLinkedList extends LinkedList {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Construct Node A");
		Node headA = createLinkedList();
		displayValues(headA);
		System.out.println(isPalindromeInPlace(headA));

	}

	private static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Stack<String> st = new Stack<String>();
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			st.push(slow.data);
			slow = slow.next;
		}

		// has odd number of elements
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data.equals(st.peek()))
				st.pop();
			slow = slow.next;
		}
		if (st.isEmpty()) 
			return true;
		return false; 

	}

	//InPlace reversal
	private static boolean isPalindromeInPlace(Node head) {
		
		Node midPointer = head;

		int i = 0;
		int size = LinkedList.count(head);
		int mid = size/2;

		//traverse until the mid element. midPointer keeps track of it
		while (i < mid && midPointer != null) {
			midPointer = midPointer.next;
			i++;
		}

		//Checking if there are odd number of nodes. moving one pointer for odd number
		if (size%2 != 0 && midPointer != null) {
			midPointer = midPointer.next;
		}
		
		//Reversing the first half of the linked list
		Node reversed = reverseHalf(head, mid);

		while (reversed != null && midPointer != null) {
			// Comparing the reversed linked list and continuing from midPointer
			if (!reversed.data.equals(midPointer.data))
				return false;
			reversed = reversed.next;
			midPointer = midPointer.next;
		}
		return true;
	}

	private static Node reverseHalf(Node headA, int mid) {
		// TODO Auto-generated method stub
		int i = 1;
		Node current = headA;
		Node previous = null;
		Node next = null;
		Node head = null;
		while (i < mid) {			
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			i++;
		}
		head = current;
		current.next = previous;
		return head;
	}
}

