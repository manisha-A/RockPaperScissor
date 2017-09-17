package com;

import java.util.Scanner;

public class RockPaperScissor {
    private static Scanner scan = new Scanner(System.in);
    private static PrintUtilities pu = new PrintUtilities();

    public static void main(String[] args) {
        beginPlaying();
    }

    /**
     * Method to prompt player whether or not she wants to play
     */
    private static void beginPlaying() {
        String COMP_PLAYER_NAME = "TheMightyPlayer";
        String COMP_PLAYER_1 = "Alpha";
        String COMP_PLAYER_2 = "Beta";
        String HUMAN_PLAYER = "You";

        pu.printHorizontal(50);
        System.out.println("\nWant to Play - Rock, Paper, Scissors?!\nType Y to play, N to exit: ");

        String input = scan.nextLine();

        if (input.toUpperCase().equals("Y")) {
            pu.printHorizontal(50);
            System.out.println("\nStarting Game ....");
            pu.printHorizontal(50);
            System.out.println("\nEnter your choice of game : \n 1: Player vs Computer \n 2: Computer vs Computer");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    new GameLogic(new Player(HUMAN_PLAYER), new Computer(COMP_PLAYER_NAME)).startGame();
                    break;
                case 2:
                    new GameLogic(new Computer(COMP_PLAYER_1), new Computer(COMP_PLAYER_2)).startGame();
                    break;
                default:
                    pu.printHorizontal(50);
                    System.out.println("\nInvalid choice.. Terminating...");
                    pu.printHorizontal(50);
                    break;
            }
        } else {
            scan.close();
        }
    }
}
