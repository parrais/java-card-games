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
            return deck.remove(0);
        } else {
            throw new IllegalStateException("The deck is empty!");
        }
    }

    public void sortDeckIntoSuitsThenValueAsc() {
        deck.sort(Comparator.comparing(Card::getSuit)
                        .thenComparing(Card::getValue));

    }

    public void sortDeckIntoSuitsThenValueDesc() {
        deck.sort(Comparator.comparing(Card::getSuit).reversed()
                .thenComparing(Comparator.comparing(Card::getValue).reversed()));
    }


    public void sortDeckByValue() {
        deck.sort((c1, c2) -> c1.getValue() - c2.getValue());
    }

}//end of class

