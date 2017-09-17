package com;

import java.util.Random;

public class Computer extends GamePlayer implements RPSPlayer{
//    private String gamePlayerName;
    Random index;

    static GameMove computerMove = null;
    GameMove[] options = GameMove.values();

    Computer(String name) {
        super(name);
        index = new Random();
    }

//    /**
//     * Method to return Player's name
//     *
//     * @return gamePlayerName
//     */
//    public String getGamePlayerName() {
//        return gamePlayerName;
//    }

    /**
     * Randomly generates computer move based on defined moves in GameMove
     * @return computermove
     */
    public GameMove getMove(){
        int moveIndex = index.nextInt(GameMove.values().length);
        computerMove = options[moveIndex];
        return computerMove;
    }
}
