package com.lint.code;

/*
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the
 * relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * 
 */
public class MoveZeros {

	private static int[] nums = new int[] {0,1,0,3,12,0,9};

	public static void main(String[] args) {

		moveZero(nums);
		for(int i :nums) {
			System.out.println(i);
		}

	}

	
	//LEET CODE SOLUTION :  seems to be a better one
	public static void moveZero(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
         
        int i = 0;
        int j = 0;
         
        // Step 1: compress the nums array by filling out the 0s
        while (i < nums.length) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
                i++;
            } else {
                i++;
            }
        }
         
        // Append 0s to the end
        while (j < nums.length) {
            nums[j] = 0;
            j++;
        }
	}
	
	
	//My Solution
		public static void moveZeroes(int[] nums) {

			if (nums == null || nums.length == 0)
				return;

			int i = 0,n = nums.length, j = 0;
			while (true) {
				while (i < n && nums[i] != 0) 
					i++;
				j = i+1;
				while (j < n && nums[j] == 0) 
					j++;
				if ( i < n && j < n)
					swap(nums,i,j);
				i++;
				if (i >= n)
					break;
			}
		}

	private static void swap(int[] nums, int i, int j) {
		// TODO Auto-generated method stub
		//System.out.println("");
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
