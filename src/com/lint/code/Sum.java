package com.lint.code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * Understand better with input a = 10; b = 2
 */
public class Sum {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a");
		String str1 = br.readLine();
		System.out.print("Enter b");
		String str2 = br.readLine();
		int a = Integer.parseInt(str1.trim());
		int b = Integer.parseInt(str2.trim());
		while (b != 0){
			
            int carry = (a & b) ; //CARRY is AND of two bits
            System.out.println("Carry ->" + carry);
          
            a = a ^b; //SUM of two bits is A XOR B
            System.out.println("Sum ->" + a);
          
            b = carry << 1; //shifts carry to 1 bit to calculate sum
            
            System.out.println("b ->" + b);
        }
       
	}



}
