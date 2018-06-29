package com.googleMF;

import java.util.Stack;

public class StackMin {

	static Stack<Integer> st = new Stack<Integer>();
	static Stack<Integer> minstack = new Stack<Integer>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		push(-1);
		System.out.println(top());
		System.out.println(getMin());	
	}

	public static void push (int x) {
		st.push(x);
		if (minstack.isEmpty() || x <= minstack.peek()) {
			minstack.push(x);
		}
	}

	public static int pop() {
		int value = 0;
		if (!st.isEmpty() && !minstack.isEmpty()) {
			value = st.pop();
			if (value == minstack.peek()) {
				minstack.pop();
			}
		}
		return value;
	}

	public static int top() {
		if (!st.isEmpty())
			return st.peek();
		return 0;
	}

	public static int getMin() {
		if (!minstack.isEmpty())
			return minstack.peek();
		return 0;
	}
}


