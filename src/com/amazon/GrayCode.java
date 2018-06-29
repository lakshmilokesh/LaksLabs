package com.amazon;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 *
 * SOLUTION :
 *
 *
 * Idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
 * 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit,
 * while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
 *
 */

import java.util.ArrayList;
import java.util.List;

public class GrayCode {

    public static void main(String[] args) {
        List<Integer> codes = grayCode(2);
        for (Integer num : codes) {
            System.out.print(num + " ");
        }

    }

    public static List<Integer> grayCode(int n) {
        int x,y;
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--) {
                x = rs.get(k);
                y = 1<<i;
                int res = x | y;
                rs.add(res);
            }

        }
        return rs;
    }
}
