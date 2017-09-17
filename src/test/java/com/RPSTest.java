package com;

import org.junit.Test;

import java.lang.reflect.Method;

public class RPSTest {

    @Test
    public void testMainForNotPlayingGame() {
        RockPaperScissor rps = new RockPaperScissor();
        String playGame = "N";
        System.setIn(new java.io.ByteArrayInputStream(playGame.getBytes()));

        rps.main(null);
    }
}
