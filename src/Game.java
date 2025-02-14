import java.util.Scanner;

public class Game {

    private Board gameBoard;

    public Game(Scanner scan) {
        int rowInput;
        int colInput;
        int[] dimensions = promptBoardSize(scan);
        rowInput = dimensions[0];
        colInput = dimensions[1];
        this.gameBoard = new Board(rowInput, colInput);
        gameBoard.printBoard();
        int mines = promptMineAmount(scan);
        dimensions = promptCoordinates(scan);
        rowInput = dimensions[0];
        colInput = dimensions[1];
        gameBoard.addMines(mines, rowInput, colInput);
        gameBoard.selectTile(rowInput, colInput);
    }

    public static int[] promptBoardSize(Scanner scan) {

        int[] coordinates = new int[2];
        do {
            System.out.print("Please enter the amount of rows: ");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number (must be more than 1)");
                scan.next();
            }
            coordinates[0] = scan.nextInt();
            if (coordinates[0] <= 1) {
                System.out.println("Row size must be 2 minimum");
            }
        } while (coordinates[0] <= 1);
        do {
            System.out.print("Please enter the amount of columns: ");
            while (!scan.hasNextInt()) {
                System.out.println("Please enter a number (must be more than 1)");
                scan.next();
            }
            coordinates[1] = scan.nextInt();
            if (coordinates[1] <= 1) {
                System.out.println("Column size must be 2 minimum");
            }
        } while (coordinates[1] <= 1);
        return coordinates;
    }

    public int promptMineAmount(Scanner scan) {
        System.out.println("Board has been generated, enter mine amount and starting coordinate to start the game.");
        int amount = 0;
        int maxMineAmount = (gameBoard.getMaxCols() - 1) * (gameBoard.getMaxRows() - 1);
        do {
            System.out.print("Please enter amount of mines: ");
            while (!scan.hasNextInt()) {
                System.out.println("Column input must be a number");
                scan.next();
            }
            amount = scan.nextInt();
            if (amount < 1) {
                System.out.println("The game must have a minimum of 1 mine");
            }
            if (amount > maxMineAmount) {
                System.out.println(
                        "You have selected more than the maximum possible amount of mines ((rows - 1) * (cols - 1))");
            }
        } while (amount < 0 || amount > maxMineAmount);
        return amount;
    }

    public int[] promptCoordinates(Scanner scan) {
        int[] coordinates = new int[2];
        do {
            System.out.print("Please enter a row: ");
            while (!scan.hasNext("[A-Za-z]")) {
                System.out.println("Row input must be a letter");
                scan.next();
            }
            coordinates[0] = (int) scan.next().toUpperCase().charAt(0) - 65;
            if (coordinates[0] < 0 || coordinates[0] >= gameBoard.getMaxRows()) {
                System.out.println("You have selected a row that is out of bounds");
            }
        } while (coordinates[0] < 0 || coordinates[0] >= gameBoard.getMaxRows());
        do {
            System.out.print("Please enter a column: ");
            while (!scan.hasNextInt()) {
                System.out.println("Column input must be a number");
                scan.next();
            }
            coordinates[1] = scan.nextInt();
            if (coordinates[1] < 0 || coordinates[1] >= gameBoard.getMaxCols()) {
                System.out.println("You have selected a column that is out of bounds");
            }
        } while (coordinates[1] < 0 || coordinates[1] >= gameBoard.getMaxCols());
        return coordinates;
    }

    public static boolean promptPlayAgain(Scanner scan) {
        String input;
        do {
            System.out.print("Would you like to play again?: ");
            input = scan.next().toLowerCase();
            if (!input.equals("yes") && !input.equals("no")) {
                System.out.println("Please enter either 'yes' or 'no'");
            }
        } while (!input.equals("yes") && !input.equals("no"));
        if (input.equals("yes")) {
            return true;
        }
        return false;
    }

    public boolean getGameStatus() {
        return gameBoard.gameIsWon();
    }

    public boolean getGameInProgress() {
        return !gameBoard.gameIsWon();
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

    public boolean inputCoordinates(int row, int col) {
        return this.gameBoard.selectTile(row, col);
    }

    public Board getBoard() {
        return gameBoard;
    }
}
