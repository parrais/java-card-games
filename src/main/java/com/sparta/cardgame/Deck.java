package com.sparta.cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Deck {
    private final List<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
        createDeck();
        shuffleDeck();
    }

    Suit[] suits = {Suit.CLUBS, Suit.DIAMONDS, Suit.HEARTS, Suit.SPADES};
    Rank[] ranks = Rank.values();

    private void createDeck() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < ranks.length; j++) {
                 Card card = new Card(suits[i], ranks[j]);
                 deck.add(card);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (!deck.isEmpty()) {
            return deck.removeFirst();
        } else {
            throw new IllegalStateException("The deck is empty!");
        } // or System.out.println("The deck is empty!");
          //  return null;
    }

    public void sortDeckIntoSuits() {
        deck.sort(Comparator.comparing(Card::getSuit)
                        .thenComparing(Card::getValue)
                        .reversed());

    }
}
placeCards(); //them
placeCards(); // you
wait(1000);
while (true)
    if
