package com.sparta.cardgame;

import java.util.Scanner;

public class BlackjackGame  {
    private Deck deck;
    private  Hand playerHand;
    private  Hand computerHand;
    private Scanner scanner;
    private int playerScore;
    private int computerScore;

    public BlackjackGame() {
      deck = new Deck();
      playerHand = new Hand();
      computerHand = new Hand();
      scanner = new Scanner(System.in);
      playerScore = 0;
      computerScore = 0;
    }

    //    ----------- setup game ---------
    public void startGame() {
        System.out.println("Welcome to the Blackjack Game!🃏");
        while(playerScore !=3 && computerScore !=3){
            playGame();
        }
        if(playerScore == 3){
            System.out.println("You win!");
        } else {
            System.out.println("You lost!");
        }
    }

    private void playGame(){
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
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        showPlayArea("computer");
        if(!checkBlackJack(computerHand)){
             while (computerHand.sumCards() < 17){
              computerHand.addToHand(deck.dealCard());
                 showPlayArea("computer");
             }
             if (computerHand.sumCards() > 21) {
                 System.out.println("Dealer Busts! You win!");
                 playerScore += 1;
             } else if (checkBlackJack(playerHand)){
                 System.out.println("You win!");
                 playerScore += 1;
             }  else {
                 if (playerHand.sumCards() > computerHand.sumCards()) {
                     System.out.println("You win!");
                     playerScore += 1;
                 } else if (computerHand.sumCards() > playerHand.sumCards()) {
                     System.out.println("You lose! The Dealer wins");
                     computerScore += 1;
                 }  else {
                     System.out.println("You lost! if you draw, the dealer wins");
                     computerScore += 1;
                 }
             }
        } else {
            System.out.println("You lose! The Dealer got BlackJack!");
            computerScore += 1;
        }


    }


    private void showPlayArea(String user){
        System.out.println("Dealer card: ");
        if(user.equals("player")){
            System.out.println(computerHand.getCards().get(0).getFormattedName());
        } else {
            for(Card card : computerHand.getCards()){
                System.out.println(card.getFormattedName());
            }
        }
        System.out.println();
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





//  Compare Results
//    - if (playerSum > dealerSum && playerSum <= 21):
//          print("Player Wins!")
//    - else if (playerSum == dealerSum):
//          print("It's a Tie!")
//    - else:
//          print("Dealer Wins!")


    //




}
