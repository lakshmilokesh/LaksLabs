package com.AmazonLessFrequent;

public class ComplexNumberMultiplication {

//    Multiplication of two complex numbers can be done as:
//
//            (a+ib)x (x+iy)=ax+i^2by+i(bx+ay)=ax-by+i(bx+ay) (a+ib)×(x+iy)=ax+i​2
//        ​​ by+i(bx+ay)=ax−by+i(bx+ay)

    public static void main(String[] args) {
        String a = "1+-1i";
        String b = "1+-1i";
        System.out.println(complexNumberMultiply(a,b));
    }

    public static String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";

    }
}
