package com.amazon;

import java.util.ArrayList;

/**
 * Write a method to return all subsets of a SET.
 *
 * For Explanation  on the solution refer "Cracking the Interview" book
 */
public class Subset {

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(1);
        set.add(2);
        int index = 0;
        ArrayList<ArrayList<Integer>> result = getSubsets(set,index);
        for (int i = 0; i < result.size(); i++) {
            ArrayList<Integer> sub = result.get(i);
            System.out.println(sub);
        }

    }

    public  static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) { //Base case : Add empty set
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>()); // Empty Set
        }
        else {
            allsubsets = getSubsets(set,index+1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moreSubsets.add(newsubset);
            }
            allsubsets.addAll(moreSubsets);

        }
        return allsubsets;
    }

}
