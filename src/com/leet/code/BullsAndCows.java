package com.leet.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Laks on 2/9/16.
 *
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match
 * the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and
 * hints to eventually derive the secret number.
 *
 * For example:
 *
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls
 * and B to indicate the cows. In the above example, your function should return "1A3B".
 *
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 *
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should
 * return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are
 * always equal.
 *
 */
public class BullsAndCows {

    public static void main(String[] args) {

        String secret = "11";
        String guess = "10";
        System.out.println(getHint(secret,guess));
    }

    public static String getHint(String secret, String guess) {

        Map<Character,Integer> stringMap = new HashMap<Character, Integer>();
        int i = 0;
        int j=0, cowsCount = 0, bullsCount = 0;
        StringBuilder sb = new StringBuilder();
        char[] secretArray = secret.toCharArray();
        char[] guessArray = guess.toCharArray();
        while(i < secret.length()) {
            stringMap.put(secretArray[i],i);
            System.out.println(secretArray[i]);
            i++;
        }
        System.out.println("================");
        while (j < guess.length()) {
            System.out.println(guessArray[j]);
            if (stringMap.containsKey(guessArray[j])) {
                if (j == stringMap.get(guessArray[j])){
                    bullsCount++;

                }
                else {
                    cowsCount++;
                }
            }
                j++;
        }
        return sb.append(bullsCount+"A"+cowsCount+"B").toString();
    }
}
