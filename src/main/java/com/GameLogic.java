package com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class GameLogic {
    private Scanner scan;
    public Boolean comparePlayerMoves(String move, String robotPlayerMove) {
        Boolean moveComparison = true;

        switch (move) {
            case "ROCK":
                moveComparison = robotPlayerMove.equals("SCISSOR");
                break;
            case "PAPER":
                moveComparison = robotPlayerMove.equals("ROCK");
                break;
            case "SCISSOR":
                moveComparison = robotPlayerMove.equals("PAPER");
                break;
        }
        return moveComparison;
    }
}
