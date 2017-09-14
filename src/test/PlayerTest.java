package test;

import org.junit.Test;
import rps.Player;

public class PlayerTest {
    @Test
    public void testPlayerInput(){
        Player player = new Player();
        assert player.playerInput("Rock").contains("ROCK");
        assert player.playerInput("Scissor").contains("SCISSOR");
        assert player.playerInput("Paper").contains("PAPER");
    }
}
