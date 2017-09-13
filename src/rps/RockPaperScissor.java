package rps;

import java.util.Scanner;

public class RockPaperScissor {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.beginPlaying();
    }

    /**
     * Method to prompt player whether or not she wants to play
     */
    private void beginPlaying() {
        System.out.println("Want to Play - Rock, Paper, Scissors?!");
        System.out.println("Type Y to play, N to exit!");

        String input = scan.nextLine();

        if (input.toUpperCase().equals("Y")) {
            System.out.println("Starting Game ....");
            System.out.println("Enter your choice of game : \n 1: Player vs Computer \n 2: Computer vs Computer");
            int choice = Integer.parseInt(scan.nextLine());
            switch (Integer.toString(choice)) {
                case "1":
                    this.startPlayerVsComputerGame();
                    break;
                case "2":
                    this.startComputerVsComputerGame();
                    break;
                default:
                    System.out.println("Invalid choice.. Terminating...");
                    break;
            }
        } else {
            scan.close();
        }
    }

    private void startPlayerVsComputerGame() {
        Player player1 = new Player();
        Computer robotPlayer = new Computer("TheMightyPlayer");
        String playerMove = player1.getMove();
        String robotPlayerMove = robotPlayer.getMove();

//      determine winner between Player & Computer
        GameLogic gameLogic = new GameLogic();
        if (playerMove.equals(robotPlayerMove)) {
            System.out.println("It's a Tie!");
        } else {
            Boolean isPlayerWon = gameLogic.comparePlayerMoves(playerMove, robotPlayerMove);
            if (isPlayerWon) {
                System.out.println("You won the game!");
            } else {
                System.out.println("You lost the game!");
            }
        }

        if (playAnotherGame()) {
            startPlayerVsComputerGame();
        } else {
            System.out.println("Game ended ....");
        }

    }

    private void startComputerVsComputerGame() {
        Computer robotPlayer1 = new Computer("Alpha");
        Computer robotPlayer2 = new Computer("Beta");
        String robotPlayer1Name = robotPlayer1.getName();
        String robotPlayer2Name = robotPlayer2.getName();
        String robotPlayer1Move = robotPlayer1.getMove();
        String robotPlayer2Move = robotPlayer2.getMove();

        System.out.println("Game is on between " + robotPlayer1Name + " and " +  robotPlayer2Name);
        System.out.println("\n");
//      determine winner between Computer & Computer
        GameLogic gameLogic = new GameLogic();
        if (robotPlayer1Move.equals(robotPlayer2Move)) {
            System.out.println("It's a Tie!");
        } else {
            Boolean isFirstPlayerWon = gameLogic.comparePlayerMoves(robotPlayer1Move, robotPlayer2Move);
            if (isFirstPlayerWon) {
                System.out.println(robotPlayer1Name + " won the game & " + robotPlayer2Name + " lost game!");
            } else {
                System.out.println(robotPlayer1Name + " lost the game!" + robotPlayer2Name + " won game!");
            }
        }

        if (playAnotherGame()) {
            startComputerVsComputerGame();
        } else {
            System.out.println("Game ended ....");
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

        String input = scan.nextLine();

        if (input.toUpperCase().equals("Y")) {
            System.out.println("Starting Game ....");
            return true;
        } else {
            scan.close();
            return false;
        }
    }
}
