import java.util.Scanner;

public class Game {

    private Board gameBoard;
    private boolean gameOver = false;

    public Game() {
        Scanner scan = new Scanner(System.in);
        int rowInput;
        int colInput;
        String rowInputStr;
        System.out.println("Welcome to Minesweeper");
        System.out.printf("Please enter amount of rows: ");
        rowInput = scan.nextInt();
        System.out.printf("Please enter amount of columns: ");
        colInput = scan.nextInt();
        this.gameBoard = new Board(rowInput, colInput);
        System.out.println("\nBoard Created, printing board\n");
        this.gameBoard.printBoard();
        System.out.printf("Enter amount of mines: ");
        int mines = scan.nextInt();
        System.out.printf("Enter Row Value: ");
        rowInputStr = scan.next();
        rowInput = ((int) rowInputStr.charAt(0)) - 65;
        System.out.printf("Enter Column Value: ");
        colInput = scan.nextInt();
        this.gameBoard.addMines(mines, rowInput, colInput);
        this.gameBoard.selectTile(rowInput, colInput);
        scan.close();
    }

    public boolean getGameOver() {
        return this.gameOver;
    }

    public void setGameOver() {
        System.out.println("Exiting Game...");
        this.gameOver = true;
    }

    public boolean command(String input) {
        switch (input) {
            case "debug":
                this.gameBoard.debugPrintBoard();
                return false;
            case "select":

            default:
                break;
        }
        return false;
    }
    // public
}
