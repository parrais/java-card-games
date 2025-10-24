package com.sparta.cardgame;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class BlackjackGame  {
    private Deck deck;
    private  Hand playerHand;
    private  Hand computerHand;
    private Scanner scanner;
    private int playerScore;
    private int computerScore;
    private boolean gameOver;

    public BlackjackGame() {
      deck = new Deck();
      playerHand = new Hand();
      computerHand = new Hand();
      scanner = new Scanner(System.in);
      playerScore = 0;
      computerScore = 0;
      gameOver = false;
      startGame();
    }

    public void startGame() {
        System.out.println("Welcome to the Blackjack Game!🃏");
        while(playerScore !=3 && computerScore !=3){
            System.out.println();
            playGame();
        }
        if(playerScore == 3){
            System.out.println("You win!");
        } else {
            System.out.println("You lost!");
        }
    }

    private void playGame(){
        playerHand.clearHand();
        computerHand.clearHand();
        playerHand.addToHand(deck.dealCard());
        computerHand.addToHand(deck.dealCard());
        playerHand.addToHand(deck.dealCard());
        computerHand.addToHand(deck.dealCard());
        showPlayArea("player");
        if(!checkBlackJack(playerHand)){
            while(true){
                String playerChoice = "";
                while(!playerChoice.equalsIgnoreCase("hit") && !playerChoice.equalsIgnoreCase("stand")){
                    System.out.println("Do you want to hit or stand?");
                    playerChoice = scanner.nextLine();
                }
                if(playerChoice.equalsIgnoreCase("hit")){
                    playerHand.addToHand(deck.dealCard());
                    showPlayArea( "player");
                    if (playerHand.sumCards() > 21) {
                        System.out.println("You lost!");
                        computerScore += 1;
                        gameOver = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (!gameOver) {
            showPlayArea("computer");
            if(!checkBlackJack(computerHand)){
                while (computerHand.sumCards() < 17){
                    computerHand.addToHand(deck.dealCard());
                    showPlayArea("computer");
                }
                if (computerHand.sumCards() > 21) {
                    System.out.println("Dealer Busts! You win!");
                    playerScore += 1;
                    gameOver = true;
                } else if (checkBlackJack(playerHand)){
                    System.out.println("You win!");
                    playerScore += 1;
                    gameOver = true;
                }  else {
                    if (playerHand.sumCards() > computerHand.sumCards()) {
                        System.out.println("You win!");
                        playerScore += 1;
                        gameOver = true;
                    } else if (computerHand.sumCards() > playerHand.sumCards()) {
                        System.out.println("You lose! The Dealer wins");
                        computerScore += 1;
                        gameOver = true;
                    }  else {
                        System.out.println("You lost! if you draw, the dealer wins");
                        computerScore += 1;
                        gameOver = true;
                    }
                }
            } else {
                System.out.println("You lose! The Dealer got BlackJack!");
                computerScore += 1;
                gameOver = true;
            }
        }
    }

    private void showPlayArea(String user){
        System.out.println("Dealer's hand:");
        if(user.equals("player")){
            System.out.println(computerHand.getCards().get(0).getFormattedName());
        } else {
            for(Card card : computerHand.getCards()){
                System.out.println(card.getFormattedName());
            }
        }
        System.out.println();
        System.out.println("Your hand:");
        for(Card card : playerHand.getCards()){
            System.out.println(card.getFormattedName());
        }
    }

    private boolean checkBlackJack(Hand hand){
        if(hand.sumCards() == 21){
            return true;
        } else {
            return false;
        }
    }
}
