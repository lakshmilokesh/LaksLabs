package com.stacks;

import java.util.*;

/**
 * Created by Laks on 1/22/16.
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and
 * only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example:
 * Given "bcabc"
 * Return "abc"
 *
 * Given "cbacdcbc"
 * Return "acdb"
 */
public class RemoveDuplicateLetters {

    static Stack<Character> s1 = new Stack<Character>();
    static Stack<Character> s2 = new Stack<Character>();

    public static void main(String[] args) {
        System.out.println( "Output->" + removeDuplicateLetters("cccxxaaaz"));
    }
    public static String removeDuplicateLetters(String s) {

        Set<Character> alphabet = new HashSet<Character>();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length();i++) {
            if (!alphabet.contains(s.charAt(i))) {
                alphabet.add(s.charAt(i));
                s1.push(s.charAt(i));
            }
        }
        while (!s1.isEmpty()) {
            char x = s1.pop();
            while (!s2.isEmpty() && s2.peek() < x) {
                s1.push(s2.pop());
            }
            s2.push(x);
        }
        while (!s2.isEmpty()) {
            str.append(s2.pop());
        }
        return str.toString();

    }
}
