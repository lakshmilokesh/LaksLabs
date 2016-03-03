package com.linked.list;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Delete a node in the middle of a singly linked list, given only access to that node.
 */
public class DeleteNode extends LinkedList{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Node head = createLinkedList();
		displayValues(head);
		System.out.println("Enter data to be deleted : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Node current = head;
		while (current != null) {
			if (current.data.equals(str)) {
				break;
			}
			current = current.next;
		}
		System.out.println("Deleted ? " + deleteNode(current));
		displayValues(head);
	}
	private static boolean deleteNode(Node n) {

		if (n == null) {
			return false;					
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
}
