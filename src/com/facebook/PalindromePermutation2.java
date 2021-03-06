package com.facebook;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no
 * palindromic permutation could be form.
 *
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 *
 *
 * Hint:
 * If a palindromic permutation exists, we just need to generate the first half of the string.
 * To generate all distinct permutations of a (half of) string, use a similar approach from:
 * Permutations II or Next Permutation.
 */
public class PalindromePermutation2 {

    public static void main(String[] args) {
        String palindrome = "aabbc";
        System.out.println(generatePalindromes(palindrome));
    }
    public static List<String> generatePalindromes(String s) {
        List<String> results = new ArrayList<>();
        if(s.length() == 0)
            return results;

        HashMap<Character, Integer> d = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(d.containsKey(s.charAt(i)))
                d.put(s.charAt(i), d.get(s.charAt(i)) + 1);
            else
                d.put(s.charAt(i), 1);
        }

        String candidate = "";
        String single = "";
        boolean already = false;

        for(Character c : d.keySet()) {
            int num = d.get(c) / 2;
            for(int i = 0; i < num; i++)
                candidate += c;
            if(d.get(c) % 2 != 0) {
                if(already)
                    return results;
                else {
                    already = true;
                    single += c;
                }
            }
        }
        System.out.println("Candidate -->" + candidate);
        if(candidate.length() == 0 && single.length() != 0) {
            results.add(single);
            return results;
        }

        recursion("", candidate, single, candidate.length(), results);
        return results;
    }

    private static void recursion(String left, String candidate, String single, int l, List<String> results) {

        if(left.length() == l) {
            String right = new StringBuffer(left).reverse().toString();
            results.add(left + single + right);
        }
        for(int i = 0; i < candidate.length(); i++) {
            if(i > 0 && candidate.charAt(i) == candidate.charAt(i - 1)) //This condition is to avoid duplicate results.
                continue;
            recursion(left + candidate.charAt(i), candidate.substring(0, i) + candidate.substring(i + 1), single, l, results);
        }
    }
}
