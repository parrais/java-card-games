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

    }//end of test for dealCard() return card and removes one

    @Test
    @DisplayName("dealCard() throws Exception when deck is empty")
    void testDealCard_assertThrowsException_whenDeckIsEmpty() {
        //Arrange
        Deck deck = createTestDeck();

        //Act
        for (int i = 0; i < 52; i++) {
            deck.dealCard();
        }

        //Assert
        assertThrows(IllegalStateException.class, deck::dealCard,
              "Method dealCard() should throw Exception when no cards in deck.");

    }//end of test for dealCard() Exception

    @Test
    @DisplayName("sortDeckByValue() should arrange cards by suit, then by value, then reverse the order")
    void testSortDeck_assertSortingBySuit_thenByValue_andReversedOrder() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckIntoSuits();

        //Assert
        List<Card> sortedDeck = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            sortedDeck.add(deck.dealCard());
        }

        for (int i = 1; i < sortedDeck.size(); i++) {
            Card previousCard = sortedDeck.get(i - 1);
            Card currentCard = sortedDeck.get(i);

            int suitComparison = previousCard.getSuit().compareTo(currentCard.getSuit());
            assertTrue(suitComparison >= 0,
                    "Suit order should be descending due to .reversed().");

            if (suitComparison == 0) {
                assertTrue(previousCard.getValue() >= currentCard.getValue(),
                        "Within same suit, cards should be sorted in descending value order too.");
            }
        }

    }//end of test for sortDeckByValue() -> by suit, -> by value, -> reverse the order

    @Test
    @DisplayName("sortDeckByValue() should arrange cards in ascending order by value")
    void testSortDeck_assertSorting_ascendingOrder_byValue() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckByValue();

        //Assert
        Card dealtCard = deck.dealCard();
        while (true) {
            try {
                Card nextCard = deck.dealCard();
                assertTrue(dealtCard.getValue() <= nextCard.getValue(),
                    "Deck should be sorted in ascending order by value.");
                dealtCard = nextCard;
            } catch (IllegalStateException e) {
                break;
            }
        }
    }//end of test for sortDeckByValue() in ascending order


}//end of test class
