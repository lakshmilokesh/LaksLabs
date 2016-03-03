package com.leet.code;

/*
 * Given an array and a value, remove all instances of that value in place and return the
 * new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 */
public class RemoveElement {

	public static int[] nums = new int[]{2,3,4,5,3,8,3,0,3};
	public static int val = 3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New Size" + removeElement(nums, val));
	}
	
    public static int removeElement(int[] nums, int val) {
        
    	int j = 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != val) {
    			nums[j] = nums[i];
    			j++;
    		}
    	}
    	int k = j;
    	while (j < nums.length) {
    		nums[j] = 0;
    		j++;
    	}

    	return k ;
    }

}
