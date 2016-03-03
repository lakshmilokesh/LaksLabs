package com.stacks;

import java.util.Stack;

/*
 * 
 */
public class QueueDescendingOrder {

	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();
	
	public Stack<Integer> descending(Stack<Integer> s1) {
		
		while (!s1.isEmpty()) {
			int x = s1.pop();
			while (!s2.isEmpty() && s2.peek() > x) {
				s1.push(s2.pop());
			}
			s2.push(x);
		}
		return s2;
	}
	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub

	}

}
