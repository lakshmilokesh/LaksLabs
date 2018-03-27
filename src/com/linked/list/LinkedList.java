package com.linked.list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class LinkedList {

	public class Node {

		public String data;
		public Node next;
		public Node() {

		}
		public Node (String d, Node n) {
			this.data = d; 
			this.next = n;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}

	}

	public static void displayValues(Node node) {

		System.out.println("== Linked list data ==");
		// TODO Auto-generated method stub
		if (node == null) {
			System.out.println("Empty");
			return;
		}
		while(node != null) {
			System.out.println(node.data);
			node = node.next;
		}		
	}

	public static Node createLinkedList() throws IOException {
		// TODO Auto-generated method stub
		Node head = null;
		Node current = null;
		BufferedReader a;
		do {
			System.out.println("Enter the data");
			LinkedList.Node n = new LinkedList().new Node();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n.data = br.readLine().trim();
			n.next = null;
			if (head == null) {				
				n.next = null;
				head = n;      
			} else {
				current = head;
				while (current.next != null) {
					current = current.next;
				}

				current.next = n;
			}
			System.out.println("Do u want to continue");
			a = new BufferedReader(new InputStreamReader(System.in));
		} while ("Y".equalsIgnoreCase(a.readLine().trim()));

		return head;

	}

	public static int count(Node headA) {
		// TODO Auto-generated method stub
		int count = 0;
		while (headA != null) {
			count++;
			headA = headA.getNext();
		}
		return count;
	}
}

