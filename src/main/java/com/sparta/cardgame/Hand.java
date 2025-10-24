package com.sparta.cardgame;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;
    private boolean aceInHand;

    public Hand() {
        cards = new ArrayList<Card>();
        aceInHand = false;
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addToHand(Card card) {
        cards.add(card);
    }

    public int sumCards() {
        int total = 0;
        for (Card card : cards) {
            total += card.getScore();
            if (card.getRank() == Rank.ACE) {
                aceInHand = true;
            }
        }
        if (aceInHand && total < 12) {
            total += 10;
        }
        return total;
    }

    // method playCard () SNAP EXTENSION
}

