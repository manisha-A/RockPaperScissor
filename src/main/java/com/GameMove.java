package com;

public enum GameMove {
    ROCK,PAPER,SCISSOR;

    public int compareMoves(GameMove move){
        if(this == move){
            return 0;
        }

        switch (this){
            case ROCK:
                return (move==SCISSOR ? 1 :-1);
            case PAPER:
                return (move==ROCK ? 1 :-1);
            case SCISSOR:
                return (move==PAPER ? 1 :-1);
        }
        return 0;
    }
}
