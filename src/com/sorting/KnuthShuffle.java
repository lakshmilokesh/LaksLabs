package com.sorting;

import java.util.Random;

/**
 * Created by Laks on 1/22/16.
 *
 * Shuffle a deck of cards.
 * Generate a random real number for each array entry
 *
 * In iteration i, pick an integer r between 0 and i
 * swap a[i] and a[r]
 *
 */
public class KnuthShuffle {

    public static void main(String[] args) {
        int[] arr = new int[]{6,3,4,1,2};
        shuffleNumbers(arr);
        System.out.println("++++++++++++++++++++++++++++++++++++");
        for(int i = 0; i < arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shuffle(Card[] cards){
        int size = cards.length;
        Random random = new Random();
        for (int i = 0; i < size; i++)  {
            int tempIndex = random.nextInt(i+1);
            Card temp = cards[i];
            cards[i] = cards[tempIndex];
            cards[tempIndex] = temp;
        }
    }

    public static void shuffleNumbers(int[] cards){
        int size = cards.length;
        Random random = new Random();
        for (int i = 0; i < size; i++)  {
            int tempIndex = random.nextInt(i+1);
            System.out.println(tempIndex);
            int temp = cards[i];
            cards[i] = cards[tempIndex];
            cards[tempIndex] = temp;
        }
    }
}

