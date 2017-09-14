package com;

import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayerInput(){
        Player player = new Player();
        assert player.playerInput("Rock").contains("ROCK");
        assert player.playerInput("Scissor").contains("SCISSOR");
        assert player.playerInput("Paper").contains("PAPER");
    }
}
