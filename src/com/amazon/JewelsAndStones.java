package com.amazon;


/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
 * Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
 * so "a" is considered a different type of stone from "A".
 *
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 *
 * Input: J = "z", S = "ZZ"
 * Output: 0
 *
 */
public class JewelsAndStones {

    public static void main(String[] args) {
        System.out.println(numJewelsInStones("ebd","bbb"));
    }

    public int numJewelsInStonesLeetCode(String J, String S) {
        int jewelTot = 0;
        for(char stone : S.toCharArray()){
            if(J.indexOf(stone) != -1) jewelTot++;
        }
        return jewelTot;
    }

    public static int numJewelsInStones(String J, String S) {

        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (J.contains(String.valueOf(c))){
                count++;
            }
        }
    return count;
    }
}
