package com.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class StackPlates {
	
	ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int  capacity;
	
	public StackPlates(int capacity) {
		this.capacity = capacity;
	}
	
	public void push(int x) {
		
		Stack<Integer> s = getLast();
		if (s != null && !s.isEmpty())
			s.push(x);
		else {
			Stack<Integer> st = new Stack<Integer>();
			st.push(x);
			stacks.add(st);
		}
	}
	
	public int pop() {
		Stack<Integer> s = getLast();
		if (s == null || s.isEmpty()) {
			stacks.remove(s.size() - 1); // check this should be stacks.remove(s);
			return 0;
		}
		int value = s.pop();
		return value;
	}
	public Stack<Integer> getLast() {
		
		if (stacks == null|| stacks.size() == 0) {
			return null;
		}
		Stack<Integer> last = stacks.get(stacks.size() - 1);
		return last;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
