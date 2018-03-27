package com.sample;

public class Split {
	public static void main(String []args) {
		/*String a = "1.0.9";
		String[] arr = a.split("\\.");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}*/

		// Checking increment and decrement operators
		int i = 1;
		int j = 1;
		Integer[] arr = new Integer[]{0,1,9};
		System.out.println(arr[i++]);
		System.out.println(i);
		System.out.println(arr[++j]);
		System.out.println(j);

		System.out.println("++++++++++++++++++++++++++++++++++");

		String s = "s";
		String p = ".1";
		System.out.println("-----"+p.substring(1));

	}
}