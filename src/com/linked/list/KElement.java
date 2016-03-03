package com.linked.list;

/*
 * Find the kth last element of a singly linked list.
 */

public class KElement extends LinkedList{

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		System.out.println("Construct Node");
		Node headA = createLinkedList();
		
		System.out.println("*********************");
		displayValues(headA);
		
		Node element = findKElement(headA,2);
		
		if (element != null)
			System.out.println("kth last element" + element.data);
		else
			System.out.println("Invalid input");
	}
	
	private static Node findKElement(Node Head, int k) {
		Node current = Head;
		int i = 0;
		Node kpointer = Head;
		
		while (current != null) {
			i++;
			current = current.next;
			if (i > k) {
				kpointer = kpointer.next;
			}
		}
		if (k > i) {
			return null;
		}
		return kpointer;
	}

}
