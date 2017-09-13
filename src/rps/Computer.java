package rps;

import utilities.GameMoves;

import java.util.Random;

public class Computer {

    /**
     * Randomly generates computer move based on defined moves in GameMoves
     * @return computermove
     */
    public String getMove(){
        String computerMove = null;
        GameMoves[] options = GameMoves.values();
        Random index = new Random();
        int moveIndex = index.nextInt(GameMoves.values().length);
        computerMove = String.valueOf(options[moveIndex]);
        System.out.println("Computer move is ...".concat(computerMove));
        return computerMove;
    }
}
