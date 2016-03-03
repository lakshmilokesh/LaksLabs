package com.sorting;

/**
 * Created by Laks on 1/22/16.
 *
 */
public class Card {

    private Suit suit;

    private Rank rank;

    public enum Suit {
        SPADES, HEARTS, DIAMONDS, CLUBS;
    }

    public enum Rank {
        ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),TEN(10),JACK(11),QUEEN(12),KING(13);

        private final int value;

        Rank(int value) {
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
        public int getValue(int i){
            return this.value;
        }
        public static Rank getRank(int i) {
            Rank ranko = Rank.ACE;
            for (Rank rank : Rank.values()) {
                if (rank.getValue() == i) {
                    ranko = rank;
                    break;
                }
            }
            return ranko;
        }
    }

    public Card(Suit suit, Rank rank) {
        this.suit  = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return getRank() + " of " + getSuit();
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

}
