package com.sparta.cardgame;

import java.util.Scanner;

public class GameApp {
    static void main() {
        System.out.println("WELCOME TO THE CASINO!\nPlease choose your game: ");
        Scanner scanner = new Scanner(System.in);
        int gameChoice = 999;
        while (gameChoice != 1 && gameChoice != 2 && gameChoice != 0) {
            System.out.print("     1. Blackjack\n     2. Snap!\n     0. (Exit the casino) \nYour choice: ");
            gameChoice = scanner.nextInt();
            switch (gameChoice) {
                case 1:
                    System.out.println("You chose Blackjack");
                    BlackjackGame game = new BlackjackGame();
                    break;
                case 2:
                    System.out.println("You chose Snap!");
                    SnapGame thisGame = new SnapGame();
                    break;
                case 0:
                    System.out.println("Good bye, please return soon...");
                    break;
                default:
                    System.out.println("Please make a choice from the menu.");
                    break;
            }
        }
        scanner.close();
        System.out.println("Thanks for visiting the Casino!");
    }
}
