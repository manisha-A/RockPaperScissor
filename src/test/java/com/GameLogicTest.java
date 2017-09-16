package com;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameLogicTest {

    GameLogic gl ;

    @Before
    public void beforeTest(){
        gl = new GameLogic();
    }

    @Test
    public void getComputerMoveTest() throws Exception{
        Computer comp = new Computer("Test");
        Method method = GameLogic.class.getDeclaredMethod("getComputerMove",Computer.class);
        method.setAccessible(true);

        assertTrue(Arrays.asList(GameMoves.values()).contains(method.invoke(gl,comp)));
    }

    @Test
    public void continuePlayingTest() throws Exception{
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertTrue((Boolean) method.invoke(gl,"Y"));
    }

    @Test
    public void continuePlayingTestReturnFalse() throws Exception{
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertFalse((Boolean) method.invoke(gl,"N"));
    }

    @Test()
    public void printHorizontalException() throws Exception {
        try {
            Method method = GameLogic.class.getDeclaredMethod("printHorizontal",int.class);
            method.setAccessible(true);
            method.invoke(gl, -1);
        }
        catch (InvocationTargetException e) {
            e.getTargetException();
            assert e.getCause().toString().contains("NegativeArraySizeException");
        }
    }

    @Test()
    public void compareMoveIllegalException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
            method.setAccessible(true);
            method.invoke(gl, 2, "player1", "player2");
        }
        catch (InvocationTargetException e) {
            e.getTargetException();
            assert e.getCause().toString().contains("IllegalArgumentException");
        }
    }

    @Test()
    public void compareMovesForWinning() throws Exception {
        Field testPlayerScore = gl.getClass().getDeclaredField("playerscore");
        Field testComputerScore = gl.getClass().getDeclaredField("robotscore");
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        method.invoke(gl,1,"player1","player2");
        Assert.assertEquals(1,testPlayerScore.getInt(gl));
        Assert.assertEquals(0,testComputerScore.getInt(gl));
    }

    @Test()
    public void compareMovesForTie() throws Exception {
        Field testPlayerScore = gl.getClass().getDeclaredField("playerscore");
        Field testComputerScore = gl.getClass().getDeclaredField("robotscore");
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(gl,0,"player1","player2");
        Assert.assertEquals(0,testPlayerScore.getInt(gl));
        Assert.assertEquals(0,testComputerScore.getInt(gl));
    }

    @Test()
    public void compareMovesForLosing() throws Exception {
        Field testPlayerScore = gl.getClass().getDeclaredField("playerscore");
        Field testComputerScore = gl.getClass().getDeclaredField("robotscore");
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(gl,-1,"player1","player2");
        Assert.assertEquals(0,testPlayerScore.getInt(gl));
        Assert.assertEquals(1,testComputerScore.getInt(gl));
    }

    @Test
    public void getPlayerMovePaper() throws Exception{
        Player pl = new Player();
        String inputData = "Paper";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Method method = gl.getClass().getDeclaredMethod("getPlayerMove", Player.class);
        method.setAccessible(true);
        assertEquals(GameMoves.PAPER, (GameMoves)method.invoke(gl,pl));
    }
}
