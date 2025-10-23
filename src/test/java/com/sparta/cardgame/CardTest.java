package com.sparta.cardgame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("getFormattedName gives output for specified card")
    void getAceSpadesDisplay() {
        Card aceOfSpades = new Card(Suit.SPADES, Rank.ACE);
        String actual = aceOfSpades.getFormattedName();
        String expected = "ACE of SPADES";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getFormattedName gives output for different card")
    void getTenClubsDisplay() {
        Card tenOfClubs = new Card(Suit.CLUBS, Rank.TEN);
        String actual = tenOfClubs.getFormattedName();
        String expected = "TEN of CLUBS";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getSuit gives correct output")
    void getTenClubsSuit() {
        Card tenOfClubs = new Card(Suit.CLUBS, Rank.TEN);
        String actual = tenOfClubs.getSuit().toString();
        String expected = "CLUBS";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getSuit gives correct output")
    void getJackClubsRank() {
        Card jackOfClubs = new Card(Suit.CLUBS, Rank.JACK);
        String actual = jackOfClubs.getRank().toString();
        String expected = "JACK";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getScore gives score for numeric card")
    void getNineClubsScore() {
        Card nineOfClubs = new Card(Suit.CLUBS, Rank.NINE);
        String actual = String.valueOf(nineOfClubs.getScore());
        String expected = String.valueOf(9);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getScore gives score for face card")
    void getQueenDiamondsScore() {
        Card queenOfDiamonds = new Card(Suit.DIAMONDS, Rank.QUEEN);
        String actual = String.valueOf(queenOfDiamonds.getScore());
        String expected = String.valueOf(10);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("getValue gives score for face card")
    void getKingDiamondsScore() {
        Card kingOfDiamonds = new Card(Suit.DIAMONDS, Rank.KING);
        String actual = String.valueOf(kingOfDiamonds.getValue());
        String expected = String.valueOf(13);
        Assertions.assertEquals(expected, actual);
    }


}

