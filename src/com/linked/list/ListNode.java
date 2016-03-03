package com.linked.list;



public class ListNode {

	public int data;
	public ListNode next;

	public ListNode (int d, ListNode n) {
		this.data = d; 
		this.next = n;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}

}
