package com.googleMF;

import java.util.*;

/*
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be
 * segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not
 * contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 */
public class WordBreak {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
//        a.add("leet");
//        a.add("code");
//        System.out.println(wordBreak("leetcode",a));
        a.add("a");
        a.add("aa");
        a.add("aaa");

        System.out.println(wordBreak("aaaaaa",a));
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet=new HashSet(wordDict);
            Queue<Integer> queue = new LinkedList<Integer>();
            int[] visited = new int[s.length()];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (visited[start] == 0) {
                    for (int end = start + 1; end <= s.length(); end++) {
                        if (wordDictSet.contains(s.substring(start, end))) {
                            queue.add(end);
                            if (end == s.length()) {
                                return true;
                            }
                        }
                    }
                    visited[start] = 1;
                }
            }
            return false;
    }
}
