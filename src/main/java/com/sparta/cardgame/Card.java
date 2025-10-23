package com.sparta.cardgame;

public class Card {
//    String suit; // Diamonds
//    String name; // Ace, 2, 9, Jack
//    int value; // 2 - 11

    private final Suit suit;
    private final Rank rank;

    //constructor Card (suit, name) name -> value
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // method getFormattedName () -> name + " of " suit
    public String getFormattedName() {
        String cardOutput = this.rank + " of " + this.suit;
        return cardOutput;
    }

    // method getShortName () -> name[0] + suit[0] ??? ♣♦♥♠


    public int getValue(){
        return rank.ordinal()+1;
    };

    public int getScore(){
        if (rank.ordinal() >= 9){
            return 10;
        }
        return rank.ordinal()+1;
    };

    @Override
    public String toString() {
        return getFormattedName();
    }

// method getName () -> name SNAP EXTENSION
}
