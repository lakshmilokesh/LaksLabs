package com.linked.list;
/*
 * Remove duplicates from an unsorted list
 * FOLLOW UP
 * No temporary buffer allowed
 */
public class RemoveDuplicates extends LinkedList {



	public static void main(String[] args) throws Exception {

		// TODO Auto-generated method stub
		Node head = createLinkedList();
		displayValues(head);

		Node n = removeDuplicate(head);
		System.out.println("After duplicates removal");
		displayValues(n);		
	}

	private static Node removeDuplicate(Node head) {
		Node current = head;

		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (current.data == runner.next.data) {
					runner.next = runner.next.next;
				}
				else {
					runner = runner.next;
				}
			}
			current = current.next;
			
		}
		return head;
	}


}

