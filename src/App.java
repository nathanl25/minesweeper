public class App {
    public static void main(String[] args) throws Exception {
        // BoardPrint.createGrid();
        // CreateArray arrray = new CreateArray();
        // arrray.printArray();
        // BoardPrint.printGrid(10, 10);
        // String[] strArr = RandomNum.generateMines(3, 4, 10, 10);
        // Board newGame = new Board(2, 2);
        Board newGame = new Board(10, 10);
        // // newGame.printBoard();
        newGame.addMines(60, 1, 1);
        newGame.debugPrintBoard();
        newGame.addNumbered();
        newGame.debugPrintBoard();
        // newGame.printBoard();
        // newGame.dumpBoardValues();
        // Tile zeroZero = newGame.gameBoard.get(0).get(0);
        // System.out.println(zeroZero);
    }
}
