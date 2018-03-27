package com.linked.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
 */

public class CheckLoop extends LinkedList{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.out.println("Enter the position to create a loop");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int position  = Integer.parseInt(br.readLine());
		Node head = createLinkedListLoop(position);
		Node found = checkLoop(head);
		if (found == null)
			System.out.println("No Loop");
		else
			System.out.println(found.data);

	}

	private static Node createLinkedListLoop(int position) throws IOException {
		// TODO Auto-generated method stub
		Node head = createLinkedList();
		Node current = head; 
		Node loop = null;
		if (position >= 0) { 
			while (current.next != null) {

				position--;
				if (position == -1) {
					loop = current;
				}
				current = current.next;
			}
			current.next = loop;
		}
		return head;
	}
	



	private static Node checkLoop(Node head) {

		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.data == fast.data) {
				break;
			}
		}
		if (fast == null || fast.next == null) {
			return null;
		}
		slow = head;
		while(slow.data != fast.data) {
			slow = slow.next;
			fast = fast.next;
		}
		return fast;
	}

}
