package com.InterviewQuestions;

/**
 * Created by Laks on 1/14/16.
 */
public class TrickyInterviewQuestions {

    public static void main(String[] args){

        /*
         * What does the following Java program print?
         *
         * This InterviewQuestions is tricky because unlike the Integer, where MIN_VALUE is negative, both the MAX_VALUE and
         * MIN_VALUE of the Double class are positive numbers. The Double.MIN_VALUE is 2^(-1074), a double constant
         * whose magnitude is the least among all double values. So unlike the obvious answer, this program will print
         * 0.0 because Double.MIN_VALUE is greater than 0.
         */

        System.out.println("1. " + Math.min(Double.MIN_VALUE, 0.0d));

        /*
         * Question: What do the expression 1.0 / 0.0 will return? will it throw Exception? any compile time error?
         *
         * it will not throw Arithmetic Exception and return Double.INFINITY. Also, note that the comparison
         * x == Double.NaN always evaluates to false, even if x itself is a NaN.
         *
         */
        System.out.println("2. " + (1.0 / 0.0));





}
}