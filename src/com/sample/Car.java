package com.sample;

public class Car extends Vehicle{

	public Car () {

		System.out.println("Car constructor");
	}
	
	int model;
	
	  static void printProperties() {
		System.out.println("Inside car class print properties method");
	}
}
