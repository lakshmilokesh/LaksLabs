package com.sample;

/**
 * Created by Laks on 1/19/16.
 * for any non-null reference values x and y, this method returns true if and only if x and y refer to the same object
 * (x == y has the value true).
 */
public class ObjectEquality {

    public static void main(String[] args) {
        Account a1 = new Account("Sandy", 10000);
        Account a2 = new Account("Sandy", 10000);

        Integer one = new Integer(10);
        System.out.println("EQUALS -->" + a1.equals(a2)); //false
        System.out.println(a1==a2);

        System.out.println(one.compareTo(null)); // Throws NullPointerException
        System.out.println(one.equals(null)); // returns false
    }
}
