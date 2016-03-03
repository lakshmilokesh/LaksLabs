package com.InterviewQuestions;

/**
 * Created by Laks on 2/16/16.
 *
 * Can you catch Runtime Exception ?
 *
 * Yes
 *
 */
public class CatchingRuntimeException {


        public static void main(String[] args) {
            try {
                throw new RuntimeException("Bang");
            } catch (Exception e) {
                System.out.println("I caught: " + e);
            }
        }

}
