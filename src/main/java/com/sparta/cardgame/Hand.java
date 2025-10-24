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



    public void clearHand() {
        cards = new ArrayList<>();
    }

    public void addToHand(Card card) {
        cards.add(card);
    }

    // method sumCards ()
    public int sumCards() {

        int total = 0;
        for (Card card : cards) {
            if (card.getRank() == Rank.ACE) {
                aceInHand = true;
            }
            total += card.getScore();
            }
        if (aceInHand && total < 12) {
            total += 10;
        }
        return total;
    }

    public Card playCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            throw new IllegalStateException("The deck is empty!");
        }
    }

}

