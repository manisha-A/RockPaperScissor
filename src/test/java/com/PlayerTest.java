package com;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerInput(){
        Player player = new Player();
        Assert.assertEquals(player.playerInput("Rock"), GameMoves.ROCK);
        Assert.assertEquals(player.playerInput("Scissor"), GameMoves.SCISSOR);
        Assert.assertEquals(player.playerInput("Rock"), GameMoves.ROCK);
        assert player.playerInput("Scissor").compareTo(GameMoves.SCISSOR) == 0;
        assert player.playerInput("Paper").compareTo(GameMoves.PAPER) == 0;
    }
}
