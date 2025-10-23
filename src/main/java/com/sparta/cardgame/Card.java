package com.sparta.cardgame;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getFormattedName() {
        String cardOutput = this.rank + " of " + this.suit;
        return cardOutput;
    }

    // method getShortName () -> name[0] + suit[0] ??? ♣♦♥♠


    public int getValue() {
        return rank.ordinal() + 1;
    }

    public int getScore() {
        if (rank.ordinal() >= 9) {
            return 10;
        }
        return rank.ordinal() + 1;
    }

    @Override
    public String toString() {
        return getFormattedName();
    }

}
