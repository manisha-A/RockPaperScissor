package com;

import java.util.Scanner;


public class Player {
    private Scanner scan;

    public Player() {
        scan = new Scanner(System.in);
    }

    /**
     * Prompts the player to input the Move
     *
     * @return playerMove
     */
    public GameMoves getMove() {
        try {
            System.out.print("Enter your move : ");
            String input = scan.nextLine();
            return playerInput(input);
        } catch (IllegalArgumentException e) {
            return getMove();
        }
    }

    public GameMoves playerInput(String playerInput) throws IllegalArgumentException {
        switch (playerInput) {
            case "Rock":
                return GameMoves.ROCK;
            case "Paper":
                return GameMoves.PAPER;
            case "Scissor":
                return GameMoves.SCISSOR;
            default:
                System.out.println("Invalid move! Please try again.");
                throw new IllegalArgumentException("Invalid move! Please try again.");
        }
    }
}
