package com;

import org.junit.Assert;
import org.junit.Test;
import utilities.GameMoves;

public class GameMovesTest {

    @Test
    public void enumValueIsNotNull(){
        Assert.assertNotNull(GameMoves.valueOf("ROCK"));
        Assert.assertNotNull(GameMoves.valueOf("PAPER"));
        Assert.assertNotNull(GameMoves.valueOf("SCISSOR"));
    }
}
