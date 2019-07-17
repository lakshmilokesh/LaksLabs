package com.GoogleLessFrequent;

/*
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: +
 * and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
Example:

Input: s = "++++"
Output:
[
  "--++",
  "+--+",
  "++--"
]
Note: If there is no valid move, return an empty list [].
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

    public static void main(String[] args) {

        List<String> result = generatePossibleNextMoves("++++");
        System.out.println(result);
    }

    public static List<String> generatePossibleNextMoves(String s) {

        List<String> result = new ArrayList<>();
        char[] str = s.toCharArray();
        String stringtoAdd = "";
        for (int i = 0; i < str.length; i++) {
            if (i+1 < str.length && str[i] == '+' && str[i+1] == '+') {
                stringtoAdd = "--";
                result.add(s.substring(0,i) + stringtoAdd + s.substring(i+2,str.length));
            }
        }
        return result;

    }
}
