package com;

import utilities.GameMoves;

import java.util.Scanner;


public class Player {
    private Scanner scan;

    public Player() {
        scan = new Scanner(System.in);
    }

    /**
     * Prompts the player to input the Move
     * @return playerMove
     */
    public String getMove() {
        System.out.println("Enter your move!");
        String input = scan.nextLine();
        return playerInput(input);
    }

    public String playerInput(String playerInput){
        switch (playerInput) {
            case "Rock":
                playerInput = String.valueOf(GameMoves.ROCK);
                break;
            case "Paper":
                playerInput = String.valueOf(GameMoves.PAPER);
                break;
            case "Scissor":
                playerInput = String.valueOf(GameMoves.SCISSOR);
                break;
            default:
                System.out.println("Invalid move! Try again..");
                return getMove();
        }
        System.out.println("You played ...".concat(playerInput));
        return playerInput;
    }
}
