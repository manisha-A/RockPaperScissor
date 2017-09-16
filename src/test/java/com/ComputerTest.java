package com;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ComputerTest {
    @Test
    public void getComputerName(){
        Computer c = new Computer("testing 123");
        assertTrue(c.getName().contains("testing 123"));
    }


    @Test
    public void getComputerMoveTest(){
        Computer c = new Computer("testing 123");
        assertTrue(Arrays.asList(GameMoves.values()).contains(c.getMove()));
    }
}
