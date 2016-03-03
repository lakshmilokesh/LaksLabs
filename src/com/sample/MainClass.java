package com.sample;

class Inner
{
	static void staticMethod()
	{
		System.out.println("Static Method");
	}
}

public class MainClass
{
	public static void main(String[] args)
	{
		Inner a = null;

		a.staticMethod(); // Does not throw NullPointerException.You can call static methods through reference variable
		                  // which is pointing to null.
	}

}