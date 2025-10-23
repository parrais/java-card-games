package com.sparta.cardgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeckTest {

    private Deck createTestDeck() {
        return new Deck();
    }

    @Test
    @DisplayName("createDeck() builds 52 unique cards")

    void testCreateDeck_builds52uniquecards() {
        //Arrange
        Deck deck = createTestDeck();
        //Act
        Set<String> cardNames = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            Card c = deck.dealCard();
            cardNames.add(c.getFormattedName());
        }
        //Assert
        assertEquals(52, cardNames.size(),
            "The deck should contain 52 unique cards (4 suits x 13 ranks.");

    }//end of test for createDeck()


    @Test
    @DisplayName("shuffleDeck() randomises card order without changing(add/remove/duplicate) the deck")

    void testShuffleDeck_randomisesCardOrder_whilstKeepingSameDeck() {
        //Arrange
        Deck deck = createTestDeck();


        //Act
    }

}//end of test class
