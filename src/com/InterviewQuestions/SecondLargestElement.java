package com.InterviewQuestions;

/**
 *  Sample Question given by Antin for ServiceNow interview
 *
 *  Questions : What if there is only one element
 *              What if all the elements are the same.
 */
public class SecondLargestElement {

    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,23,6,45,67,11,90};
        System.out.println("Second Largest : " + secondLargest(a));

    }

    public static int secondLargest(int[] a) {
        int max = a[0];
        int sec_max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                sec_max = max;
                max = a[i];
            }
            else if (a[i] > sec_max) {
                sec_max = a[i];
            }
        }
        return sec_max;
    }
}
