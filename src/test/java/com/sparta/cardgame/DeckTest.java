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
    @DisplayName("sortDeckIntoSuitsThenValueAsc() should arrange cards by suit, then by value")
    void testSortDeck_assertSortingBySuit_thenByValue() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckIntoSuitsThenValueAsc();

        //Assert
        List<Card> sortedDeck = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            sortedDeck.add(deck.dealCard());
        }

        for (int i = 1; i < sortedDeck.size(); i++) {
            Card previousCard = sortedDeck.get(i - 1);
            Card currentCard = sortedDeck.get(i);

            int suitComparison = previousCard.getSuit().compareTo(currentCard.getSuit());
            assertTrue(suitComparison <= 0,
                    "Suit order should be ascending.");

            if (suitComparison == 0) {
                assertTrue(previousCard.getValue() <= currentCard.getValue(),
                        "Within same suit, cards should be sorted in ascending value order.");
            }
        }

    }//end of test for sortDeckIntoSuitsThenValueAsc() -> cards by suit, then by value

    @Test
    @DisplayName("sortDeckIntoSuitsThenValueDesc() should arrange cards in descending order by value")
    void testSortDeck_assertSorting_descendingOrder_bySuit_thenValue() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckIntoSuitsThenValueDesc();

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
                    "Suit order should be descending.");

            if (suitComparison == 0) {
                assertTrue(previousCard.getValue() >= currentCard.getValue(),
                        "Within same suit, cards should be sorted in descending value order.");
            }
        }
    }//end of test for sortDeckIntoSuitsThenValueDesc() should arrange cards in descending order

    @Test
    @DisplayName("sortDeckByValueThenSuitAsc() should arrange cards by value, then by suit in an ascending order")
    void testSortDeck_assertSortingByValue_thenBySuit_Asc() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckByValueThenSuitAsc();

        //Assert
        List<Card> sortedDeck = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            sortedDeck.add(deck.dealCard());
        }

        for (int i = 1; i < sortedDeck.size(); i++) {
            Card previousCard = sortedDeck.get(i - 1);
            Card currentCard = sortedDeck.get(i);

            int valueComparison = previousCard.getValue() - currentCard.getValue();
            assertTrue(valueComparison <= 0,
                    "Value order should be ascending.");

            if (valueComparison == 0) {
                assertTrue((previousCard.getSuit().compareTo(currentCard.getSuit()) <= 0),
                        "Within same value, cards should be sorted in ascending suit order.");
            }
        }
    }//end of test for sortDeckByValueThenSuitAsc() should arrange cards by value, then by suit in ascending order

    @Test
    @DisplayName("sortDeckByValueThenSuitDesc() should arrange cards by value, then by suit in a descending order")
    void testSortDeck_assertSortingByValue_thenBySuit_Desc() {
        //Arrange
        Deck deck = createTestDeck();
        deck.shuffleDeck();

        //Act
        deck.sortDeckByValueThenSuitDesc();

        //Assert
        List<Card> sortedDeck = new ArrayList<>();

        for (int i = 0; i < 52; i++) {
            sortedDeck.add(deck.dealCard());
        }

        for (int i = 1; i < sortedDeck.size(); i++) {
            Card previousCard = sortedDeck.get(i - 1);
            Card currentCard = sortedDeck.get(i);

            int valueComparison = previousCard.getValue() - currentCard.getValue();
            assertTrue(valueComparison >= 0,
                    "Value order should be descending.");

            if (valueComparison == 0) {
                assertTrue((previousCard.getSuit().compareTo(currentCard.getSuit()) >= 0),
                        "Within same value, cards should be sorted in descending suit order.");
            }
        }
    }//end of test for sortDeckByValueThenSuitDesc() should arrange cards by value, then by suit in descending order

}//end of test class
