package com.stacks;

import com.linked.list.LinkedList;

public class StackImplementation extends LinkedList{
	
	Node top;

	public void push(String item){
		Node n = new LinkedList().new Node(item, null);
		n.next = top;
		top = n;
	}
	
	public String peek() {
		if (top != null) {
			return top.data;
		}
		return null;
	}
	
	public String pop () {
		if (top != null) {
			String data = top.data;
			top = top.next;
			return data;
		}
		return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
