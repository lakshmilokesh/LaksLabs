package com.linked.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Partition a linked list around a value x, such that all nodes less than x come before all nodes greater 
 * than or equal to x.
 */
public class PartitionLinkedList extends LinkedList{

	private static Node Lefthead = null;
	private static Node rightHead = null;
	private static Node xNode = null;

	public static void main(String[] args) throws IOException {
		
		// TODO Auto-generated method stub
		Node head = createLinkedList();
		displayValues(head);
		
		System.out.println("Enter the partition data");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		partition(head, Integer.parseInt(str));
	}

	private static void partition (Node head, int x) {
		
		Node current = head;

		while (current != null) {

			if (Integer.parseInt(current.data) < x) {
				Lefthead = add(Lefthead,current);
			}
			else if (Integer.parseInt(current.data) > x) {
				rightHead = add(rightHead,current);
			}
			else if(Integer.parseInt(current.data) == x){
				xNode = current;
			}
			current = current.next;
		}
		
		Node mergedNode = mergeLinkedList();
		displayValues(mergedNode);

	}
	private static Node mergeLinkedList() {
		
		// TODO Auto-generated method stub
		Node traverse = Lefthead;
		if (traverse != null) {
			while (traverse.next != null) {
				traverse = traverse.next;
			}
			if (xNode != null) {
				Node newNode = new LinkedList().new Node(xNode.data,null);
				traverse.next = newNode;
				newNode.next = rightHead;
			}
			else {
				traverse.next = rightHead;
			}
			return Lefthead;
		}
		else {
			if(xNode != null) {
				Node newNode = new LinkedList().new Node(xNode.data,null);
				newNode.next = rightHead;
				return newNode;
			}
		}
		return rightHead;

	}

	private static Node add(Node h, Node n) {
		Node current = h;
		Node newNode = new LinkedList().new Node(n.data,null);
		if (h == null) {
			h = newNode;
			return h;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;	
		return h;
	}


}
