package com.sample;

public class Vehicle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Vehicle v = new Vehicle();
		int i = 2;
		Integer wrap = new Integer(12);
		Vehicle.test(i);
		Vehicle.test(wrap);
		Vehicle.printProperties();
		
		
		/*
		 * Bike a = (Bike)new Vehicle();
		 * Exception in thread "main" java.lang.ClassCastException: com.sample.Vehicle cannot
		 * be cast to com.sample.Bike at com.sample.Vehicle.main(Vehicle.java:15
		 * 
		 */
		Vehicle c = new Bike();
		c.printProperties();
		


	}
	
	String color;
	int speed;
	int size;
	public Vehicle() {
		System.out.println("Vehicle constructor");
	}
	
	  static void printProperties() {
		System.out.println("inside vehicle class print properties method");
	}
	 
	 public static void test(int num){
	    System.out.println("method with primitive argument");
		              
		}
		  
		public static void test(Integer num){
		    System.out.println("method with wrapper argument");
		              
		}

}
