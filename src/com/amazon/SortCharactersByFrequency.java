package com.amazon;

/*
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * 0(nlogn)
 */

import java.util.Arrays;
import java.util.Comparator;

public class SortCharactersByFrequency {

    public static void main(String[] args) {

        System.out.println(frequencySort("cacaca"));

    }
    public static String frequencySort(String s) {
        Character[] ch = new Character[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            ch[i++] = (Character) c;
        }
        int[] map = new int[256];
        for (char c : s.toCharArray()) {
            map[c]++;
        }
        Arrays.sort(ch, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                int diff = map[c2] - map[c1];
                return diff == 0 ? (c1 - c2) : diff ;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.toString();
    }
}
