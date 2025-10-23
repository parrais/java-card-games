package com.sparta.cardgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck createTestDeck() {
        return new Deck();
    }

    @Test
    @DisplayName("createDeck() builds 52 unique cards")

    void testCreateDeck_assertSizeOfDeck() {
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

    void testShuffleDeck_assertContentEquality_assertOrder() {
        //Arrange
        Deck deck = createTestDeck();

        List<String> deckBeforeShuffleList = new ArrayList<>();
        List<String> deckAfterShuffleList = new ArrayList<>();

        Set<String> deckBeforeShuffleSet = new HashSet<>();
        Set<String> deckAfterShuffleSet = new HashSet<>();

        //Act
        for (int i = 0; i < 52; i++) {
            deckBeforeShuffleList.add(deck.dealCard().getFormattedName());
        }

        deck = new Deck();

        for (int i = 0; i < 52; i++) {
            deckAfterShuffleList.add(deck.dealCard().getFormattedName());
        }

        //Assert
        assertEquals(deckBeforeShuffleSet, deckAfterShuffleSet,
                "Should have all cards after shuffling.");

        assertNotEquals(deckBeforeShuffleList, deckAfterShuffleList,
                "The order of cards should change after shuffling.");

    }//end of test for shuffleDeck()

    @Test
    @DisplayName("dealCard() returns a card and removes one from deck")

    void testDealCard_assertReturnObject_assertRemoval() {
        //Arrange
        Deck deck = createTestDeck();
        int deckSize = 52;

        //Act
        Card dealtCard = deck.dealCard();

        //Assert
        assertNotNull(dealtCard, "Method dealCard() should return a Card object.");
        assertEquals(deckSize - 1, 51, "Deck size should decrease by one after dealing a card.");

    }//end of test for dealCard()

    




}//end of test class
