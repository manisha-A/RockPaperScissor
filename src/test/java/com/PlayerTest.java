package com;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerInput() {
        Player player = new Player();
        Assert.assertEquals(player.playerInput("Rock"), GameMoves.ROCK);
        Assert.assertEquals(player.playerInput("Scissor"), GameMoves.SCISSOR);
        Assert.assertEquals(player.playerInput("Paper"), GameMoves.PAPER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomPlayerInput() {
        Player player = new Player();
        player.playerInput("random");
    }
}
