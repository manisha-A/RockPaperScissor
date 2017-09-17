package com;

public class GamePlayer {
    private String gamePlayerName;

    GamePlayer(String name) {
        this.gamePlayerName = name;
    }

    /**
     * Method to return Player's name
     *
     * @return gamePlayerName
     */
    public String getGamePlayerName() {
        return gamePlayerName;
    }
}
