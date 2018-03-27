package com.lint.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 * Time Complexity o(n^2)
 *
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        // DO NOT write main() function
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if(nums.length<3)
            return res;

        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i==0 || nums[i]>nums[i-1]){ //avoid duplicate solutions

                int j=i+1, k=nums.length-1;

                while(j<k){
                    if(nums[j]+nums[k]==-nums[i]){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        res.add(temp);
                        k--;
                        j++;
                        while(k>j && nums[k]==nums[k+1]) k--;//avoid duplicate solutions

                        while(j<k && nums[j]==nums[j-1]) j++;//avoid duplicate solutions

                    }else if(nums[j]+nums[k]>nums[i]){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }
        return res;
    }

}
