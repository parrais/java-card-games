package com.sparta.cardgame;

public class Card {
//    String suit; // Diamonds
//    String name; // Ace, 2, 9, Jack
//    int value; // 2 - 11
    public enum Suit{
        Clubs,Diamonds,Hearts,Spades
    }
    public enum Name {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private final Suit suit;
    private final Name name;

    //constructor Card (suit, name) name -> value
    public Card(Suit suit, Name name) {
        this.suit = suit;
        this.name = name;
    }

    // method getFormattedName () -> name + " of " suit
    // method getShortName () -> name[0] + suit[0] ???

    // method getValue () -> value
    public int getValue(){
        if (name.ordinal() >= 9){
            return 10;
        }
        return name.ordinal()+1;
    };

    // method getName () -> name SNAP EXTENSION
}
