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

    }
    public static void shuffle(Card[] cards){
        int size = cards.length;
        Random random = new Random();
        for (int i = 0; i <= size; i++)  {
            int tempIndex = random.nextInt(i+1);
            Card temp = cards[i];
            cards[i] = cards[tempIndex];
            cards[tempIndex] = temp;
        }
    }
}

