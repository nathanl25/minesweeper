import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("Welcome to Minesweeper");
        Scanner scan = new Scanner(System.in);

        boolean activeGame = true;
        while (activeGame) {
            Game newGame = new Game(scan);
            boolean gameInProgress = newGame.getGameInProgress();
            while (gameInProgress) {
                newGame.getBoard().printBoard();
                int[] coordinates = newGame.promptCoordinates(scan);
                int row = coordinates[0];
                int col = coordinates[1];
                gameInProgress = newGame.inputCoordinates(row, col);
            }
            boolean gameIsWon = newGame.getGameStatus();
            if (gameIsWon) {
                System.out.println("Congratulations, you win!");
                newGame.getBoard().printBoard();
            } else {
                System.out.println("Better luck next time, revealing board.\n");
                newGame.getBoard().debugPrintBoard();
            }
            activeGame = Game.promptPlayAgain(scan);
        }
        System.out.println("Thank you for playing, exiting Game...");
        scan.close();
    }
}
