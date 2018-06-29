package com.amazon;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by Laks on 2/1/16.
 *
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalTriangle2 {

    public static void main(String[] args) {
         int index = 3;
        System.out.println(" Pascal Triangle index" + index + " : " + getRow(index));
    }

    public static List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (rowIndex < 0)
            return result;

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = result.size() - 2; j >= 0; j--) {
                result.set(j + 1, result.get(j) + result.get(j + 1));
            }
            result.add(1);
        }
        return result;
    }
}
