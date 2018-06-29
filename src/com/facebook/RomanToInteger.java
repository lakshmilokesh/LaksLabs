package com.facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Integer ->" + romanToInt("IV"));
	}
	
    public static int romanToInt(String s) {
        Map<Character,Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
        
        int i = 0;
        int sum = 0;
        int length = s.length();
        int prev = 0, curr = 0;
        while (i < length) {

        	 curr = mapping.get(s.charAt(i));
        	 if (curr > prev) {
        		sum = sum + (curr - 2*prev); 
        	 }
        	 else {
        		 sum = sum + curr;
        	 }
        	prev = curr;
        	i++;
        }
        return sum;
    }

}
