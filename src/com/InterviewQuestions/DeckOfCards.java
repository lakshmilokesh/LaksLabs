package com.InterviewQuestions;

import com.sorting.Card;

/**
 * Created by Laks on 1/21/16.
 *
 *
 * Methods for OO Design
 *
 * 1. Shuffle
 * 2. hasNext
 * 3. next
 * 4. isRed
 */
public class DeckOfCards {

    private Card[] cards;

    private int index;

    public DeckOfCards() {
        cards = new Card[52];
        Card card;
        int i = 0;
        for (Card.Suit suit : Card.Suit.values()) {
            for(Card.Rank rank : Card.Rank.values()) {
                card = new Card(suit,rank);
                cards[i++] = card;
            }

        }
    }

    public boolean hasNext() {
        return index < cards.length;
    }

    public Card next() {
        return cards[index++];
    }

    public boolean isRed(Card card) {
        return Card.Suit.DIAMONDS.equals(card.getSuit()) || Card.Suit.HEARTS.equals(card.getSuit());
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
}
