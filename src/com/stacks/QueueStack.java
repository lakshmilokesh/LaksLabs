package com.stacks;

import java.util.Stack;

/*
 * Implement Queue using Stack.
 *
 * Interview Question asked in Oracle
 */
public class QueueStack {
	
	Stack<Integer> newest, oldest;
	  
	public QueueStack() {
		newest = new Stack<Integer>();
		oldest = new Stack<Integer>();
	}

	public void push(int x) {
		newest.push(x);
	}
	
	public int size() {
		return newest.size() + oldest.size();
	}
	
	public void shift() {
		if (oldest.isEmpty()) {
			while(!newest.isEmpty()) {
				oldest.push(newest.pop());
			}
		}
	}
	
	public int peek() {
		shift();
		return oldest.peek();
	}
	
	public int pop() {
		shift();
		return oldest.pop();
	}
	
    public boolean empty() {
        return newest.isEmpty() && oldest.isEmpty();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
