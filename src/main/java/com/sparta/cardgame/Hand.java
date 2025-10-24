package com.sparta.cardgame;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<Card>();
    }

    public Hand(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    // method addToHand(Game?)
//    public void addToHand(Deck gameDeck) {
//        Card deckCard = gameDeck.deal();
//        cards.add(deckCard);
//    }

    public void addToHand(Card card) {
        cards.add(card);
    }

    // method sumCards ()
    public int sumCards() {
        int total = 0;
        for (Card card : cards) {
            total += card.getScore();
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

