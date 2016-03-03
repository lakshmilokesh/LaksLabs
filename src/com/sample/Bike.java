package com.sample;

public class Bike extends Vehicle{

	String model;
	
	public Bike() {
		System.out.println("Bike constructor");
	}
	
	 static void printProperties() {
		System.out.println("Bike print properties");
	}
}
