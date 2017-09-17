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

    @Test
    public void continuePlayingComputerVsComputerTest() throws Exception{
        gl = new GameLogic(new Computer("comp1"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertTrue((Boolean) method.invoke(gl,"Y"));
    }

    @Test
    public void continuePlayingPlayerVsComputerTest() throws Exception{
        gl = new GameLogic(new Player("test"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertTrue((Boolean) method.invoke(gl,"Y"));
    }

    @Test
    public void continuePlayingTestPlayerVsComputerReturnFalse() throws Exception{
        gl = new GameLogic(new Player("test"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertFalse((Boolean) method.invoke(gl,"N"));
    }

    @Test
    public void continuePlayingTestComputerVsComputerReturnFalse() throws Exception{
        gl = new GameLogic(new Computer("comp1"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("continuePlaying",String.class);
        method.setAccessible(true);
        Assert.assertFalse((Boolean) method.invoke(gl,"N"));
    }

    @Test()
    public void compareMoveComputervsComputerIllegalException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Computer player1 =new Computer("comp1");
        Computer player2 = new Computer("comp");

        gl = new GameLogic(player1,player2);
        try {
            Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
            method.setAccessible(true);
            method.invoke(gl, 2, player1.getGamePlayerName(), player2.getGamePlayerName());
        }
        catch (InvocationTargetException e) {
            e.getTargetException();
            assert e.getCause().toString().contains("IllegalArgumentException");
        }
    }

    @Test()
    public void compareMoveHumanvsComputerIllegalException() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Player player1 = new Player("human");
        Computer player2 = new Computer("comp");
        gl = new GameLogic(player1,player2);
        try {
            Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
            method.setAccessible(true);
            method.invoke(gl, 2, player1.getGamePlayerName(), player2.getGamePlayerName());
        }
        catch (InvocationTargetException e) {
            e.getTargetException();
            assert e.getCause().toString().contains("IllegalArgumentException");
        }
    }

    @Test()
    public void compareMovesForWinning() throws Exception {
        Player player1 = new Player("human");
        Computer player2 = new Computer("comp");
        gl = new GameLogic(player1,player2);
        Field testPlayerScore = gl.getClass().getDeclaredField("player1score");
        Field testComputerScore = gl.getClass().getDeclaredField("player2score");
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        method.invoke(gl,1,player1.getGamePlayerName(),player2.getGamePlayerName());
        Assert.assertEquals(1,testPlayerScore.getInt(gl));
        Assert.assertEquals(0,testComputerScore.getInt(gl));
    }

    @Test()
    public void playerMovesForTie() throws Exception {
        Player player1 = new Player("human");
        Computer player2 = new Computer("comp");
        gl = new GameLogic(new Player("human"),new Computer("comp"));
        Field testPlayerScore = gl.getClass().getDeclaredField("player1score");
        Field testComputerScore = gl.getClass().getDeclaredField("player2score");
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(gl,0,player1.getGamePlayerName(),player2.getGamePlayerName());
        Assert.assertEquals(0,testPlayerScore.getInt(gl));
        Assert.assertEquals(0,testComputerScore.getInt(gl));
    }

    @Test()
    public void computerPlayersMoveForTie() throws Exception {
        Computer player1 =new Computer("comp1");
        Computer player2 =new Computer("comp");
        gl = new GameLogic(player1,player2);
        Field testPlayerScore = gl.getClass().getDeclaredField("player1score");
        Field testComputerScore = gl.getClass().getDeclaredField("player2score");
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(gl,0,player1.getGamePlayerName(),player2.getGamePlayerName());
        Assert.assertEquals(0,testPlayerScore.getInt(gl));
        Assert.assertEquals(0,testComputerScore.getInt(gl));
    }

    @Test()
    public void compareMovesForLosing() throws Exception {
        Player player1 =new Player("human");
        Computer player2 =new Computer("comp");
        gl = new GameLogic(player1,new Computer("comp"));
        Field testPlayerScore = gl.getClass().getDeclaredField("player1score");
        Field testComputerScore = gl.getClass().getDeclaredField("player2score");
        testPlayerScore.setAccessible(true);
        testComputerScore.setAccessible(true);
        Method method = gl.getClass().getDeclaredMethod("comparePlayerMoves", int.class, String.class, String.class);
        method.setAccessible(true);
        method.invoke(gl,-1,player1.getGamePlayerName(),player2.getGamePlayerName());
        Assert.assertEquals(0,testPlayerScore.getInt(gl));
        Assert.assertEquals(1,testComputerScore.getInt(gl));
    }

    @Test
    public void playAnotherGameComputerVsComputerTest() throws Exception{
        gl = new GameLogic(new Computer("comp1"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("playAnotherGame");
        method.setAccessible(true);
        String inputData = "Y";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertTrue((Boolean) method.invoke(gl));
    }

    @Test
    public void notPlayingAnotherGameComputerVsComputerTest() throws Exception{
        gl = new GameLogic(new Computer("comp1"),new Computer("comp"));
        Method method = GameLogic.class.getDeclaredMethod("playAnotherGame");
        method.setAccessible(true);
        String inputData = "N";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        Assert.assertFalse((Boolean) method.invoke(gl));
    }
}
