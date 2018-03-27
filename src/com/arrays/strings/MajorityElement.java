package com.arrays.strings;


public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {2,3,2,1,2,0,2,0,2,2,5};
		int majorityElement = findMajorityELement(input);
		if (validateMajorityElement(input, majorityElement))
			System.out.println("Majority Element :" + majorityElement);
		else
			System.out.println("No Majority");
		
	}
	
	private static int findMajorityELement(int[] input) {
		int majorityindex = 0;
		int count = 1;
		for (int i = 1; i < input.length ; i++) {
			if (input[i] == input[majorityindex])
				count++;
			else
				count--;
			
			if (count == 0) {
				majorityindex = i;
				count = 1;
			}
		}
		
		return input[majorityindex];
	}
	
	private static boolean validateMajorityElement(int[] input, int majorityElement) {
		System.out.println(majorityElement);
		int count = 0;
		for (int i : input) {
			if (i == majorityElement)
				count++;
		}
		
		if (count >= input.length/2)
			return true;
		
		return false;
	}

}
