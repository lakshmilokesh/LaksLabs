package com.Facebook2020;

/*
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 *
 * Note: The input string may contain letters other than the parentheses ( and ).
 *
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParanthesis {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("())"));
    }
    
    private StringBuilder removeInvalidClosing(CharSequence string, char open, char close) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == open) {
                balance++;
            } if (c == close) {
                if (balance == 0) continue; // balance zero indicates that its balanced already, so ignore the ')' you encounter now
                balance--;
            }
            sb.append(c);
        }  
        return sb;
    }
    public String minRemoveToMakeValid(String s) {
        StringBuilder result = removeInvalidClosing(s, '(', ')');
        result = removeInvalidClosing(result.reverse(), ')', '(');
        return result.reverse().toString();
    }
}
