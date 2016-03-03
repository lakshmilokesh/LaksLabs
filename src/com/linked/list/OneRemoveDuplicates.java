package com.linked.list;

import java.util.HashSet;
import java.util.Set;

/*
 * Remove duplicates from an unsorted list
 * FOLLOW UP
 * Case 2 : No temporary buffer allowed
 */
public class OneRemoveDuplicates extends LinkedList{
	
	

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		Node head = createLinkedList();
		displayValues(head);
		
		Node n = removeDuplicate(head);
		System.out.println("After duplicates removal");
		displayValues(n);		
	}

	private static Node removeDuplicate(Node node) {
		// TODO Auto-generated method stub
		
		Set<String> removeSet = new HashSet<String>();
		Node previous = null;
		Node head = node;
		if(node == null) {
			System.out.println("Node empty to remove");
			
		}
		while(node != null) {

			if (removeSet.contains(node.data)) {
				previous.next = node.next;			
			}
			else {
				removeSet.add(node.data);
				previous = node;
			}
			node = node.next;
		}	
		return head;
	}

	

}
