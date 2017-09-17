package com;

import java.util.Scanner;

public class GameLogic {
    GamePlayer player1;
    GamePlayer player2;
    PrintUtilities pu;
    private Scanner scan = new Scanner(System.in);
    private int player1score = 0;
    private int player2score = 0;
    private int gameno = 0;

    GameLogic(GamePlayer player1, GamePlayer player2) {
        this.player1 = player1;
        this.player2 = player2;
        pu = new PrintUtilities();
    }

    void startGame() {
        GameMove player1Move = null;
        GameMove player2Move = null;
        System.out.printf("\nStarting Game between %s and %s\n",player1.getGamePlayerName(),player2.getGamePlayerName());

        if (player1 instanceof Player) {
            player1Move = ((Player) player1).getMove();
        } else {
            player1Move = ((Computer) player1).getMove();
        }

        if (player2 instanceof Player) {
            player2Move = ((Player) player2).getMove();
        } else {
            player2Move = ((Computer) player2).getMove();
        }
        System.out.printf("\n%s played %s and %s played %s\n",player1.getGamePlayerName(),String.valueOf(player1Move),player2.getGamePlayerName(),String.valueOf(player2Move));
        comparePlayerMoves(player1Move.compareMoves(player2Move), player1.getGamePlayerName(), player2.getGamePlayerName());
        gameno++;

        if (playAnotherGame()) {
            startGame();
        } else {
            finalResults(gameno, player1score, player2score, player1.getGamePlayerName(), player2.getGamePlayerName());
        }
    }

    private void comparePlayerMoves(int moveComparison, String player1, String player2) throws IllegalArgumentException {
        switch (moveComparison) {
            case 0:
                pu.printHorizontal(50);
                System.out.println("\nIt's a Tie!\n");
                break;
            case 1:
                player1score++;
                pu.printHorizontal(50);
                System.out.printf("\n%s won the game & %s lost the game!\n", player1, player2);
                break;
            case -1:
                player2score++;
                pu.printHorizontal(50);
                System.out.printf("\n%s lost the game & %s won the game!\n", player1, player2);
                break;
            default:
                throw new IllegalArgumentException("Invalid argument. Can't be other than 0,1,-1");
        }
    }

    /**
     * Method to determine whether player wants to play again
     *
     * @return boolean
     */
    private boolean playAnotherGame() {
        System.out.println("Want to Play again ?!");
        System.out.println("Type Y to play, N to exit!");

        Scanner scan1 = new Scanner(System.in);
        String anotherGame = scan1.nextLine();
        return continuePlaying(anotherGame);
    }

    /**
     * Method to determine whether player wants to continue playing
     *
     * @return boolean
     */
    private boolean continuePlaying(String anotherGame) {
        boolean isAnotherGame = false;
        switch (anotherGame) {
            case "Y":
                System.out.println("Starting Game ....");
                isAnotherGame = true;
                break;

            case "N":
                scan.close();
                break;
        }
        return isAnotherGame;
    }

    /**
     * Method to print result outcome on command line
     *
     * @param totalGames
     * @param player1score
     * @param player2score
     * @param player
     * @param anotherplayer
     * @throws IllegalArgumentException
     */
    private void finalResults(int totalGames, int player1score, int player2score, String player, String anotherplayer) throws IllegalArgumentException {
        pu.printHorizontal(50);
        System.out.println("\nGame ended ....");
        pu.printHorizontal(50);
        System.out.println("\nPrinting Results: ");
        pu.printHorizontal(50);
        System.out.printf("\nOut of %d games\n%s won %d games\nand %s won %d games", totalGames, player, player1score, anotherplayer, player2score);
    }
}
