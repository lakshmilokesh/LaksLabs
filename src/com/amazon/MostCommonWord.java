package com.amazon;

/*
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not
 * case sensitive. The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
Explanation:
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"),
and that "hit" isn't the answer even though it occurs more because it is banned.
 *
 *
 */

import java.util.*;

public class MostCommonWord {

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(mostCommonWord(paragraph,banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        Map<String, Integer> frequency = new HashMap<>();
        List<String> ban = Arrays.asList(banned);
        paragraph = paragraph.replaceAll("[^A-Za-z ]","").toLowerCase();
        String[] a = paragraph.split("\\s+");
        for (String s : a) {
            if (!ban.contains(s)) {
                frequency.put(s,frequency.getOrDefault(s,0)+1);
            }
        }

        Map<String, Integer> result2 = new LinkedHashMap<>();
        frequency.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(1)
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        String max = result2.entrySet().stream().findFirst().get().getKey();
        return max;

    }
}
