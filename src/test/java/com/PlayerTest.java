package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player pl;

    @Before
    public void setUp(){
        pl = new Player();
    }

    @Test
    public void testPlayerInput() {
        Assert.assertEquals(pl.playerInput("Rock"), GameMoves.ROCK);
        Assert.assertEquals(pl.playerInput("Scissor"), GameMoves.SCISSOR);
        Assert.assertEquals(pl.playerInput("Paper"), GameMoves.PAPER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomPlayerInput() {
        pl.playerInput("random");
    }

    @Test
    public void getPlayerMoveRock(){
        String inputData = "Rock";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(),GameMoves.ROCK);
    }

    @Test
    public void getPlayerMovePaper(){
        String inputData = "Paper";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(),GameMoves.PAPER);
    }

    @Test
    public void getPlayerMoveScissor(){
        String inputData = "Scissor";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(),GameMoves.SCISSOR);
    }
}
