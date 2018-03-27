package com.leet.code;

/*
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * 
 * 
 */
public class RemoveDuplicates2 {

	private static final int[] nums = new int[]{1,1,2,2,3,3,3,4,5,5,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int j = removeDuplicates(nums);
		System.out.println("New Count ->"+j);
	}
    public static int removeDuplicates(int[] nums) {

        int j = 1;
        int count = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i-1] == nums[i] && count < 2) {
    			nums[j] = nums[i];
    			j++;
    			count++;
    		}
    		if (nums[i-1] != nums[i]) {
    			nums[j] = nums[i];
    			count = 1;
    			j++;
    		}
    	}

		return j;
    
    }
}
