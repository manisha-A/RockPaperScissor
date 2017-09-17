package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    Player pl;

    @Before
    public void setUp(){
        pl = new Player("player1");
    }

    @Test
    public void testPlayerInput() {
        Assert.assertEquals(pl.playerInput("Rock"), GameMove.ROCK);
        Assert.assertEquals(pl.playerInput("Scissor"), GameMove.SCISSOR);
        Assert.assertEquals(pl.playerInput("Paper"), GameMove.PAPER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomPlayerInput() {
        pl.playerInput("random");
    }

    @Test
    public void getPlayerMoveRock(){
        String inputData = "Rock";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(), GameMove.ROCK);
    }

    @Test
    public void getPlayerMovePaper(){
        String inputData = "Paper";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(), GameMove.PAPER);
    }

    @Test
    public void getPlayerMoveScissor(){
        String inputData = "Scissor";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertEquals(pl.getMove(), GameMove.SCISSOR);
    }
}
