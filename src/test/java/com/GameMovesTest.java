package com;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameMovesTest {

    @Test
    public void enumValueIsNotNull(){
        Assert.assertNotNull(GameMoves.valueOf("ROCK"));
        Assert.assertNotNull(GameMoves.valueOf("PAPER"));
        Assert.assertNotNull(GameMoves.valueOf("SCISSOR"));
    }

    @Test
    public void playerWinsRockForComputersScissors(){
        assertEquals(1,GameMoves.ROCK.compareMoves(GameMoves.SCISSOR));
    }

    @Test
    public void playerLoosesRockForComputersPaper(){
        assertEquals(-1,GameMoves.ROCK.compareMoves(GameMoves.PAPER));
    }

    @Test
    public void playerWinsPaperForComputersRock(){
        assertEquals(1,GameMoves.PAPER.compareMoves(GameMoves.ROCK));
    }

    @Test
    public void playerLoosesPaperForComputersScissor(){
        assertEquals(-1,GameMoves.PAPER.compareMoves(GameMoves.SCISSOR));
    }


    @Test
    public void playerWinsScissorForComputersPaper(){
        assertEquals(1,GameMoves.SCISSOR.compareMoves(GameMoves.PAPER));
    }

    @Test
    public void playerLoosesScissorForComputersRock(){
        assertEquals(-1,GameMoves.SCISSOR.compareMoves(GameMoves.ROCK));
    }

    @Test
    public void gameIsTieForROCK(){
        assertEquals(0,GameMoves.ROCK.compareMoves(GameMoves.ROCK));
    }

    @Test
    public void gameIsTieForPaper(){
        assertEquals(0,GameMoves.PAPER.compareMoves(GameMoves.PAPER));
    }

    @Test
    public void gameIsTieForScissor(){
        assertEquals(0,GameMoves.SCISSOR.compareMoves(GameMoves.SCISSOR));
    }

}
