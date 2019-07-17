package com.AmazonLessFrequent;

/*
 *
 *
 *
 *
 */

public class OptimalDivision {

    public static void main(String[] args) {
        int[] nums = new int[] {1000,100,10,2};
        System.out.println(optimalDivision(nums));
    }

    public static String optimalDivision(int[] nums) {
        String str = "";
        if(nums.length == 0){
            return str;
        }
        str = str + nums[0];
        if(nums.length == 1){
            return str;
        }
        str = str + "/";
        if(nums.length == 2){
            return str + nums[1];
        }
        str = str + "(" + nums[1];
        for(int i = 2; i < nums.length; i++){
            str = str + "/" + nums[i];
        }
        str = str + ")";
        return str;
    }
}
