package com.stacks;

import com.linked.list.LinkedList;

public class QueueImplementation extends LinkedList {

	Node first,last;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void enqueue(String str) {
		Node item = new LinkedList().new Node(str, null);
		if (first == null) {
			first = item;
			last = item;
		}
		else {
			last.next = item;
			last = last.next;
		}
	}

	public String dequeue() {
		if (first != null) {
			String data =  first.data;
			first = first.next;
			return data;
		}
		return null;
	}
}
