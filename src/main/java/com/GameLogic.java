package com;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class GameLogic{
    private Scanner scan = new Scanner(System.in);
    private int playerscore = 0;
    private int robotscore = 0;
    private int gameno = 0;

    /**
     * Method to prompt player whether or not she wants to play
     */
    public void beginPlaying() {
        printHorizontal(50);
        System.out.println("\nWant to Play - Rock, Paper, Scissors?!");
        printHorizontal(50);
        System.out.print("\nType Y to play, N to exit: ");

        String input = scan.nextLine();

        if (input.toUpperCase().equals("Y")) {
            printHorizontal(50);
            System.out.println("\nStarting Game ....");
            printHorizontal(50);
            System.out.println("\nEnter your choice of game : \n 1: Player vs Computer \n 2: Computer vs Computer");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    this.startPlayerVsComputerGame();
                    break;
                case 2:
                    this.startComputerVsComputerGame();
                    break;
                default:
                    printHorizontal(50);
                    System.out.println("\nInvalid choice.. Terminating...");
                    printHorizontal(50);
                    break;
            }
        } else {
            scan.close();
        }
    }

    private void startPlayerVsComputerGame() {
        Player player1 = new Player();
        Computer robotPlayer = new Computer("TheMightyPlayer");

        //      determine winner between Player & Computer
        comparePlayerMoves(getPlayerMove(player1).compareMoves(getComputerMove(robotPlayer)), "Manisha", robotPlayer.getName());

        gameno++;
        if (playAnotherGame()) {
            startPlayerVsComputerGame();
        } else {
            finalResults(gameno, playerscore, robotscore, "Manisha", robotPlayer.getName());
        }

    }

    private GameMoves getPlayerMove(Player pl) {
        GameMoves playerMove = pl.getMove();
        printHorizontal(50);
        System.out.printf("\nYou played %s\n", String.valueOf(playerMove));
        return playerMove;
    }

    private GameMoves getComputerMove(Computer comp) {
        GameMoves robotPlayerMove = comp.getMove();
        printHorizontal(50);
        System.out.printf("\nComputer played %s\n", String.valueOf(robotPlayerMove));
        return robotPlayerMove;
    }

    private void startComputerVsComputerGame() {
        Computer robotPlayer1 = new Computer("Alpha");
        Computer robotPlayer2 = new Computer("Beta");
        String robotPlayer1Name = robotPlayer1.getName();
        String robotPlayer2Name = robotPlayer2.getName();

        System.out.printf("Game is on between %s and %s \n", robotPlayer1Name, robotPlayer2Name);
        System.out.printf("%s's move is %s\n", robotPlayer1Name, String.valueOf(getComputerMove(robotPlayer1)));
        System.out.printf("%s's move is %s\n", robotPlayer2Name, String.valueOf(getComputerMove(robotPlayer2)));
//      determine winner between Computer1 & Computer2
        comparePlayerMoves(getComputerMove(robotPlayer1).compareMoves(getComputerMove(robotPlayer2)), robotPlayer1Name, robotPlayer2Name);

        gameno++;
        boolean nextGame = playAnotherGame();
        if (nextGame) {
            startComputerVsComputerGame();
        } else {
            finalResults(gameno, playerscore, robotscore, robotPlayer1Name, robotPlayer2Name);
        }

    }

    /**
     * Method to determine whether player wants to play again
     *
     * @return
     */
    private boolean playAnotherGame() {
        System.out.println("Want to Play again ?!");
        System.out.println("Type Y to play, N to exit!");

        Scanner scan1 = new Scanner(System.in);
        String anotherGame = scan1.nextLine();
        return continuePlaying(anotherGame);
    }

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

    private void printHorizontal(int number) throws NegativeArraySizeException{
        int[] array = new int[number];

        for (int i = 0; i < array.length; i++) {
            System.out.print("-");
        }
    }

    private void comparePlayerMoves(int moveComparison, String player1, String player2) throws IllegalArgumentException{
        switch (moveComparison) {
            case 0:
                printHorizontal(50);
                System.out.println("\nIt's a Tie!\n");
                break;
            case 1:
                playerscore++;
                printHorizontal(50);
                System.out.printf("\n%s won the game & %s lost the game!\n", player1, player2);
                break;
            case -1:
                robotscore++;
                printHorizontal(50);
                System.out.printf("\n%s lost the game & %s won the game!\n", player1, player2);
                break;
            default:
                throw new IllegalArgumentException("Invalid argument. Can't be other than 0,1,-1");
        }
    }

    private void finalResults(int totalGames, int player1score, int player2score, String player, String anotherplayer) {
        printHorizontal(50);
        System.out.println("\nGame ended ....");
        printHorizontal(50);
        System.out.println("\nPrinting Results: ");
        printHorizontal(50);
        System.out.printf("\nOut of %d games\n%s won %d games\nand %s won %d games", totalGames, player, player1score, anotherplayer, player2score);
    }
}
