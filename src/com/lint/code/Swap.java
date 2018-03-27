package com.lint.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swap {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a");
		int a = Integer.parseInt(br.readLine().trim());
		System.out.print("Enter b");
		int b = Integer.parseInt(br.readLine().trim());
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
/*
		a = a + b;
		b = a - b;
		a = a - b;*/

		System.out.println("Swapped a ->" + a + "b -> " + b);
		

	}

}
