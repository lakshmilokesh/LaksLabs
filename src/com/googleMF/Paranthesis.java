package com.googleMF;

import java.util.Stack;
/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine
 * if the input string is valid.The brackets must close in the correct order, "()" and "()[]{}" 
 * are all valid but "(]" and "([)]" are not.
 *
 * AMAZON / FB/ SERVICE NOW
 */
public class Paranthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("[");
		System.out.println("Correct Input ? " + paranthesis(str));
	}

	private static boolean paranthesis(String s) {

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if(ch == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
            if(ch == '}') {
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }
            if(ch == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
	}
}
