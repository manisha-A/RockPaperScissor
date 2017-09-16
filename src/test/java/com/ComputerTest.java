package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ComputerTest {
    Computer c;

    @Before
    public void setUp(){
        c = new Computer("testing 123");
    }

    @Test
    public void getComputerName(){

        assertTrue(c.getName().contains("testing 123"));
    }


    @Test
    public void getComputerMoveTest(){
        assertTrue(Arrays.asList(GameMoves.values()).contains(c.getMove()));
    }
}
