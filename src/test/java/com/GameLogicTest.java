package com;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;
import static org.junit.runner.Request.method;

public class GameLogicTest {

    @Test
    public void continuePlayingTest() throws Exception{
        GameLogic gl = new GameLogic();
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertTrue((Boolean) method.invoke(gl,"Y"));
    }

    @Test
    public void continuePlayingTestReturnFalse() throws Exception{
        GameLogic gl = new GameLogic();
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertFalse((Boolean) method.invoke(gl,"N"));
    }

    @Test()
    public void printHorizontalException() throws Exception {
        try {
            GameLogic gl = new GameLogic();
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
            GameLogic gl = new GameLogic();
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
        GameLogic gl =new GameLogic();
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
        GameLogic gl =new GameLogic();
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
        GameLogic gl =new GameLogic();
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
}
