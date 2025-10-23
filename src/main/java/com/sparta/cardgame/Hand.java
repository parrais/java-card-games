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

    // method addToHand(Game?)
    public void addToHand(Deck gameDeck) {
        Card deckCard = gameDeck.deal();
        cards.add(deckCard);
    }

    // method sumCards ()
    public int sumCards() {
        int total = 0;
        for (Card card : cards) {
            // .getValue() placeholder method
            total += card.getValue();
        }
        return value;
    }

    // method playCard () SNAP EXTENSION


}

