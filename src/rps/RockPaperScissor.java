package rps;

import utilities.GameMoves;

import java.util.Scanner;

public class RockPaperScissor {

    static  Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        RockPaperScissor rockPaperScissor = new RockPaperScissor();
        rockPaperScissor.beginPlaying();
    }

    /**
     * Method to prompt player whether or not she wants to play
     */
    private void beginPlaying(){
        System.out.println("Want to Play - Rock, Paper, Scissors?!");
        System.out.println("Type Y to play, N to exit!");

        String input = scan.nextLine();

        if(input.toUpperCase().equals("Y")){
            System.out.println("Starting Game ....");
            this.startGame();
        }
        else{
            scan.close();
        }
    }

    private void startGame() {
        Player player1 = new Player();
        Computer robotPlayer = new Computer();
        String playerMove = player1.getMove();
        String robotPlayerMove = robotPlayer.getMove();

//      determine winner between Player & Computer
        GameLogic gameLogic = new GameLogic();
        if(playerMove.equals(robotPlayerMove)){
            System.out.println("It's a Tie!");
        }
        else{
            Boolean isPlayerWon = gameLogic.comparePlayerMoves(playerMove,robotPlayerMove);
            if(isPlayerWon){
                System.out.println("You won the game!");
            }
            else{
                System.out.println("You lost the game!");
            }
        }

        if(playAnotherGame()){
            startGame();
        }
        else
        {
            System.out.println("Game ended ....");
        }

    }

    /**
     * Method to determine whether player wants to play again
     * @return
     */
    private boolean playAnotherGame(){
        System.out.println("Want to Play again ?!");
        System.out.println("Type Y to play, N to exit!");

        String input = scan.nextLine();

        if(input.toUpperCase().equals("Y")){
            System.out.println("Starting Game ....");
            return true;
        }
        else{
            scan.close();
            return  false;
        }
    }
}
