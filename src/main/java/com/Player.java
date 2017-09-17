package com;

import java.util.Scanner;


public class Player extends GamePlayer implements RPSPlayer{
    Player(String name){
        super(name);
    }

    /**
     * Prompts the player to input the Move
     *
     * @return playerMove
     */
    public GameMove getMove() {
        try {
            System.out.print("Enter your move : ");
            Scanner scan = new Scanner(System.in);;
            String input = scan.nextLine();
            return playerInput(input);
        } catch (IllegalArgumentException e) {
            return getMove();
        }
    }

    /**
     * Returns Enum from UserInput
     * @param playerInput
     * @return
     * @throws IllegalArgumentException
     */
    public GameMove playerInput(String playerInput) throws IllegalArgumentException {
        switch (playerInput) {
            case "Rock":
                return GameMove.ROCK;
            case "Paper":
                return GameMove.PAPER;
            case "Scissor":
                return GameMove.SCISSOR;
            default:
                System.out.println("Invalid move! Please try again.");
                throw new IllegalArgumentException("Invalid move! Please try again.");
        }
    }
}
