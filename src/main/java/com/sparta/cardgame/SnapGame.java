package com.sparta.cardgame;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SnapGame{
    private Deck snapDeck = new Deck();
    private Hand playerHand = new Hand();
    private Hand discard = new Hand();
    private Hand computerHand = new Hand();
    private Scanner scan;

    public SnapGame() {
        snapDeck = new Deck();
        playerHand = new Hand();
        discard = new Hand();
        computerHand = new Hand();
        scan = new Scanner(System.in);

        System.out.println("Let's play snap!");
        dealSnapGame();
        while(!playerHand.getCards().isEmpty() &&
                !computerHand.getCards().isEmpty()) {
            playSnapGame();
        }
        if(!playerHand.getCards().isEmpty()){
            System.out.println("Sorry, you lost at Snap!");
        } else {
            System.out.println("Congratulations, you won at Snap!");
        }
    }

    private void playSnapGame() {
        promptEnterKey();
        Card currentComputerCard;
        Card currentPlayerCard = playerHand.playCard();
        System.out.println("You played the "+ currentPlayerCard);
        System.out.println("Cards left: player: " + playerHand.getCards().size() + " opponent: " + computerHand.getCards().size());
        discard.addToHand(currentPlayerCard);
        wait2Seconds();
        while(!playerHand.getCards().isEmpty() &&
                !computerHand.getCards().isEmpty()) {
            promptEnterKey();
            currentComputerCard = computerHand.playCard();
            System.out.println("Your opponent played the "+ currentComputerCard);
            System.out.println("Cards left: player: " + playerHand.getCards().size() + " opponent: " + computerHand.getCards().size());
            wait2Seconds();
            if (currentComputerCard.getValue() == currentPlayerCard.getValue()){
                System.out.print("********** That was a MATCH! Did you say 'SNAP'? ********** ");
                String playerResponse = scan.nextLine();
                if (playerResponse.equalsIgnoreCase("y") || playerResponse.equalsIgnoreCase("yes")){
                    while (!discard.getCards().isEmpty()) {
                        playerHand.addToHand(discard.playCard());}
                } else {
                    while (!discard.getCards().isEmpty()) {
                        computerHand.addToHand(discard.playCard());
                    }
                }
            } else { discard.addToHand(currentComputerCard);}
            promptEnterKey();
            currentPlayerCard = playerHand.playCard();
            System.out.println("You played the "+ currentPlayerCard);
            System.out.println("Cards left: player: " + playerHand.getCards().size() + " opponent: " + computerHand.getCards().size());
            wait2Seconds();
            if (currentComputerCard.getValue() == currentPlayerCard.getValue()){
                System.out.print("********** That was a MATCH! Did you say 'SNAP'? ********** ");
                String playerResponse = scan.nextLine();
                if (playerResponse.equalsIgnoreCase("y") || playerResponse.equalsIgnoreCase("yes")){
                    while (!discard.getCards().isEmpty()) {
                        playerHand.addToHand(discard.playCard());}
                } else {
                    while (!discard.getCards().isEmpty()) {
                        computerHand.addToHand(discard.playCard());}
                }
            } else { discard.addToHand(currentComputerCard);}
        }


    }



    private void dealSnapGame() {
        for (int i = 0; i < 26; i++) {
            playerHand.addToHand(snapDeck.dealCard());
            computerHand.addToHand(snapDeck.dealCard());
        }
    }

    public void promptEnterKey(){
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void wait2Seconds() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
