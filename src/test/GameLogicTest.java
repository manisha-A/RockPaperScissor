package test;

import org.junit.Assert;
import org.junit.Test;
import rps.GameLogic;
import rps.RockPaperScissor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class GameLogicTest {

    @Test
    public void playerWinsRockForComputersScissors(){
        GameLogic gameLogic = new GameLogic();
        assertTrue(gameLogic.comparePlayerMoves("ROCK","SCISSOR"));
    }

    @Test
    public void playerLoosesRockForComputersPaper(){
        GameLogic gameLogic = new GameLogic();
        assertFalse(gameLogic.comparePlayerMoves("ROCK","PAPER"));
    }

    @Test
    public void playerWinsPaperForComputersRock(){
        GameLogic gameLogic = new GameLogic();
        assertTrue(gameLogic.comparePlayerMoves("PAPER","ROCK"));
    }

    @Test
    public void playerLoosesPaperForComputersScissor(){
        GameLogic gameLogic = new GameLogic();
        assertFalse(gameLogic.comparePlayerMoves("PAPER","SCISSOR"));
    }

    @Test
    public void playerWinsScissorForComputersPaper(){
        GameLogic gameLogic = new GameLogic();
        assertTrue(gameLogic.comparePlayerMoves("SCISSOR","PAPER"));
    }

    @Test
    public void playerLoosesScissorForComputersRock(){
        GameLogic gameLogic = new GameLogic();
        assertFalse(gameLogic.comparePlayerMoves("SCISSOR","SCISSOR"));
    }
}
