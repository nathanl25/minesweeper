import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        int rowInput;
        int colInput;
        String rowInputStr;
        System.out.println("Welcome to Minesweeper");
        Scanner scan = new Scanner(System.in);
        System.out.printf("Please enter amount of rows: ");
        rowInput = scan.nextInt();
        System.out.printf("Please enter amount of columns: ");
        colInput = scan.nextInt();
        Board newGame = new Board(rowInput, colInput);
        System.out.println("\nBoard Created, printing board\n");
        newGame.printBoard();
        System.out.printf("Enter amount of mines: ");
        int mines = scan.nextInt();
        System.out.printf("Enter Row Value: ");
        rowInputStr = scan.next();
        rowInput = ((int) rowInputStr.charAt(0)) - 65;
        System.out.printf("Enter Column Value: ");
        colInput = scan.nextInt();
        newGame.addMines(mines, rowInput, colInput);
        newGame.selectTile(rowInput, colInput);
        newGame.printBoard();
        boolean gameOver = false;
        while (gameOver == false) {
            System.out.printf("Enter Row Value: ");
            rowInputStr = scan.next();
            rowInput = ((int) rowInputStr.charAt(0)) - 65;
            System.out.printf("Enter Column Value: ");
            colInput = scan.nextInt();
            gameOver = newGame.selectTile(rowInput, colInput);
            newGame.printBoard();
        }

        if (newGame.gameIsWon()) {
            System.out.println("Congratulations, you win!");
            newGame.printBoard();
        } else {

            System.out.println("Better luck next time, revealing board.\n");
            newGame.debugPrintBoard();
        }
        scan.close();
        // // newGame.debugPrintBoard();
        // // newGame.selectTile(1, 1);
        // // newGame.printBoard();
        // // newGame.debugPrintBoard();
        // newGame.addNumbered();
        // newGame.debugPrintBoard();
        // newGame.debugRemainingTiles();
        // newGame.printBoard();
        // newGame.dumpBoardValues();
        // Tile zeroZero = newGame.gameBoard.get(0).get(0);
        // System.out.println(zeroZero);
    }
}
