package com.googleMF;

/*
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
 * which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R
 * (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a
 * circle.
 *
 * Example 1:
 * Input: "UD"
 * Output: true
 *
 * Example 2:
 * Input: "LL"
 * Output: false
 *
 */

public class JungleRouteCircle {

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }
    public static boolean judgeCircle(String moves) {

        int x =0, y =0;
        for (Character c : moves.toCharArray()) {
            if (c == 'U')
                y++;
            else if (c == 'D')
                y--;
            else if (c == 'L')
                x--;
            else if(c =='R')
                x++;
        }
        return x == 0 && y == 0;
    }
}
