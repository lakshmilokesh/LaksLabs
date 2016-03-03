package com.apple;

import java.util.Random;

/**
 * Created by Laks on 1/14/16.
 * Write the code necessary to shuffle a deck of cards.
 */
public class ShuffleCards {


    public static void main(String[] args) {

        int[] op = shuffle(new int[] {0,1,2,3,4,5,6,7,8,9});

        for (int i: op) {
            System.out.print(i+"\t");
        }

    }

    public static int[] shuffle(int[] input) {

        Random rand = new Random();

        for (int i = 0 ; i < input.length; i++) {
            int min = i;
            int max = input.length;
            int index = rand.nextInt((max - min) + 1) + min;

            int temp = input[i];
            input[i] = input[index-1];
            input[index-1] = temp;
        }

        return input;
    }

}
