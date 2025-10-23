package com.sparta.cardgame;

import java.util.Scanner;

public abstract class Game {
    protected final Deck deck;
    protected final Hand playerHand;
    protected final Hand computerHand;
    protected final Scanner scanner;

    public Game() {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.computerHand = new Hand();
        this.scanner = new Scanner(System.in);
    }

    // abstract methode that each spec. game should implement
    public abstract void playGame();

    // shared setup to dealing with hands
    protected void setupGame(){
//        deck.shuffle();
//        playerHand.clear();
//        computerHand.clear();
//        System.out.println("Starting a new Game. Deck shuffled!");
    }

    // SNAP EXTENSION
    //  abstract addCardToHand
    //  abstract method hasFinish
    protected abstract boolean hasFinished();
}
