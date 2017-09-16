package com;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String name;
    Computer(String name){
        this.name = name;
    }

    /**
     * Randomly generates computer move based on defined moves in GameMoves
     * @return computermove
     */
    public GameMoves getMove(){
        GameMoves computerMove = null;
        GameMoves[] options = GameMoves.values();
        Random index = new Random();
        int moveIndex = index.nextInt(GameMoves.values().length);
        computerMove = options[moveIndex];
        return computerMove;
    }

    public String getName(){
        return name;
    }
}
