package com.sparta.cardgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    @Test
    void addToHandAddsCard() {
        // Arrange
        Hand myTestHand = new Hand();
        Card myTestCard = new Card(Suit.SPADES, Rank.TWO);
        ArrayList<Card> myTestCards = new ArrayList<Card>();
        myTestCards.add(myTestCard);
        Hand expected = new Hand(myTestCards);
        // Act
        myTestHand.addToHand(myTestCard);
        ArrayList<Card> result = myTestHand.getCards();
        // Asset
        Assertions.assertEquals(expected.getCards(), result);
    }

    @Test
    void sumValueSumsValuesOneCard() {
        // Arrange
        Hand myTestHand = new Hand();
        Card myTestCard = new Card(Suit.SPADES, Rank.TWO);
        int expected = 2;
        // Act
        myTestHand.addToHand(myTestCard);
        int result = myTestHand.sumCards();
        // Asset
        Assertions.assertEquals(expected, result);
    }

    @Test
    void sumValueSumsValuesTwoCards() {
        // Arrange
        Hand myTestHand = new Hand();
        Card myTestCard1 = new Card(Suit.SPADES, Rank.TWO);
        Card myTestCard2 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        int expected = 12;
        // Act
        myTestHand.addToHand(myTestCard1);
        myTestHand.addToHand(myTestCard2);
        int result = myTestHand.sumCards();
        // Asset
        Assertions.assertEquals(expected, result);
    }
}
