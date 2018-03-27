package com.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a list of Dominos, find if there exists a pair such that the sum of the left and sum of the right numbers
 * add up to 6
 *
 * Example: [2, 5], [3, 4], [4, 1] => yes ;
 */
public class Dominos {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{2,3},{2,4},{2,1}};
        int target = 4;
        System.out.println("Result : " + findSix(arr,target));
    }

    public static boolean findSix(int[][] dominoes, int target){

        int len = dominoes.length;

        boolean [][] found = new boolean[128][128];
        for(int[] l : dominoes){
            if(found[target - l[0]][target - l[1]]) {
                return true;
            }
            found[l[0]][l[1]]=true;
        }

        return false;
    }
}
