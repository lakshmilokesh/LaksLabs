package com.sample;

public class Boxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = new Integer(9);
		//int i = 8;
		box(i);
		System.out.println("After Method call returns : "+i);

	}

	private static void box(int i) {
		// TODO Auto-generated method stub
		System.out.println("Inside Called method : Before Increment : "+i);
		i++;
		System.out.println("Inside Called method : After Increment : " + i);
	}

}
