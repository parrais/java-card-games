package com.sparta.cardgame;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class HandTest {

    @Test
    void addToHandAddsCard() {
        // Arrange
        Hand myTestHand = new Hand();
        Card myTestCard = null;
        ArrayList<Card> myTestCards = ArrayList<Card>(myTestCard);
        Hand expected = new Hand({myTestCard})
        // Act
        Hand result = myTestHand.addToHand(myTestCard);
        // Asset
        Assertions.assertEquals(expected, result);
    }
}

//@Test
//    void speakReturnsRawrForTiger() {
//        // Arrange
//        Animal tiger = new Tiger("a", 2000, 1, 1, "b");
//        String expected = "rawr.";
//        // Act
//        var result = tiger.speak();
//        // Assert
//        Assertions.assertEquals(expected, result);
//    }