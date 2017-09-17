package com;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;

public class RPSTest {

    @Test
    public void testMainForNotPlayingGame() throws Exception{
        String playGame = "N";
        System.setIn(new java.io.ByteArrayInputStream(playGame.getBytes()));

        RockPaperScissor rps = new RockPaperScissor();
        Method method = rps.getClass().getDeclaredMethod("beginPlaying");
        method.setAccessible(true);

        method.invoke(rps);
    }
}
