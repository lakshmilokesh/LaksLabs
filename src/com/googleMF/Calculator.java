package com.googleMF;

import java.util.Stack;

/**
 * Created by Laks on 1/22/16.
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative
 * integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 */
public class Calculator {

    public static void main(String[] args) {
        System.out.println("Output : " + calculate("1+1"));

    }

    private static void pushOrAddOrMinus(
            String str,
            Stack<String> stack
    ) {
        if (stack.empty() || stack.peek().equals("(")) {
            stack.push(str);
            return;
        }
        int val = Integer.valueOf(str);
        if (stack.peek().equals("+")) {
            stack.pop();
            int val_o = Integer.valueOf(stack.pop());
            stack.push(String.valueOf(val_o + val));
        } else if (stack.peek().equals("-")) {
            stack.pop();
            int val_o = Integer.valueOf(stack.pop());
            stack.push(String.valueOf(val_o - val));
        }
    }

    public static int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Stack<String> stack = new Stack<String>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '+') {
                stack.push("+");
                i++;
            } else if (s.charAt(i) == '-') {
                stack.push("-");
                i++;
            } else if (s.charAt(i) == '(') {
                stack.push("(");
                i++;
            } else if (s.charAt(i) == ')') {
                String str = stack.pop();
                stack.pop(); //check this - not required
                i++;
                pushOrAddOrMinus(str, stack);
            } else if (s.charAt(i) == ' ') {
                i++;
            } else {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                String str = s.substring(i, j);
                i = j;
                pushOrAddOrMinus(str, stack);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
