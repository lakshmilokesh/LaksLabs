package com.sample;

public class Overflow {

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println("Max===>"+overflowValue(Integer.MAX_VALUE));
		System.out.println(Integer.MIN_VALUE);
		System.out.println("Min===>"+underflowValue(Integer.MIN_VALUE));
	}
	
	public static int overflowValue(int value) {
		value += 1;
		return value;
	}
	
	public static int underflowValue(int value) {
		value -= 1;
		return value;
	}

}
