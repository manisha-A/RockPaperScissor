package com;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameMoveTest {

    @Test
    public void enumValueIsNotNull(){
        Assert.assertNotNull(GameMove.valueOf("ROCK"));
        Assert.assertNotNull(GameMove.valueOf("PAPER"));
        Assert.assertNotNull(GameMove.valueOf("SCISSOR"));
    }

    @Test
    public void rockVsScissorsTest(){
        assertEquals(1, GameMove.ROCK.compareMoves(GameMove.SCISSOR));
    }

    @Test
    public void rockVsPaperTest(){
        assertEquals(-1, GameMove.ROCK.compareMoves(GameMove.PAPER));
    }

    @Test
    public void paperVsRockTest(){
        assertEquals(1, GameMove.PAPER.compareMoves(GameMove.ROCK));
    }

    @Test
    public void paperVsScissorTest(){
        assertEquals(-1, GameMove.PAPER.compareMoves(GameMove.SCISSOR));
    }


    @Test
    public void scissorVsPaperTest(){
        assertEquals(1, GameMove.SCISSOR.compareMoves(GameMove.PAPER));
    }

    @Test
    public void scissorVsRockTest(){
        assertEquals(-1, GameMove.SCISSOR.compareMoves(GameMove.ROCK));
    }

    @Test
    public void gameIsTieForROCK(){
        assertEquals(0, GameMove.ROCK.compareMoves(GameMove.ROCK));
    }

    @Test
    public void gameIsTieForPaper(){
        assertEquals(0, GameMove.PAPER.compareMoves(GameMove.PAPER));
    }

    @Test
    public void gameIsTieForScissor(){
        assertEquals(0, GameMove.SCISSOR.compareMoves(GameMove.SCISSOR));
    }

}
