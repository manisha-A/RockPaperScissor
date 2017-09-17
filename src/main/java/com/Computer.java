package com;

import java.util.Random;

public class Computer extends GamePlayer implements RPSPlayer{
    private String name;
    Random index;

    static GameMove computerMove = null;
    GameMove[] options = GameMove.values();

    Computer(String name) {
        super(name);
        index = new Random();
    }

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
