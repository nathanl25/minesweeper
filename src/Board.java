import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Board {
    private static final String VERTICAL_LINE = "\u2503";
    private static final String HORIZONTAL_LINE = "\u2501\u2501\u2501";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String MINE = "\u2738";
    public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
    public static final String RED_BOLD = "\033[1;31m"; // RED
    public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
    public static final String WHITE_BOLD = "\033[1;37m"; // WHITE
    public static final String RED_BACKGROUND = "\033[41m"; // RED
    public ArrayList<ArrayList<Tile>> gameBoard;
    private int maxRows;
    private int maxCols;

    public Board(int rows, int cols) {
        this.maxRows = rows;
        this.maxCols = cols;
        gameBoard = new ArrayList<ArrayList<Tile>>();
        for (int i = 0; i < rows; i++) {
            ArrayList<Tile> row = new ArrayList<Tile>();
            for (int j = 0; j < cols; j++) {
                row.add(new Tile("blank", i, j));
            }
            gameBoard.add(row);
        }
    }

    public void addMines(int mineAmount, int startRow, int startCol) {
        int startPosition = (startRow * maxCols) + startCol;
        List<Integer> mineCoords = this.generateMineCoords(mineAmount, startPosition);
        for (Integer coord : mineCoords) {
            int x = coord / maxCols;
            int y = coord % maxCols;
            gameBoard.get(x).get(y).setType("mine");
            // Hashmap
        }
        // addNumbered();
    }

    private List<Integer> generateMineCoords(int mineAmount, int startPosition) {
        ArrayList<Integer> mineList = new ArrayList<>();
        for (int i = 0; i < (maxRows * maxCols); i++) {
            mineList.add(i);
        }
        mineList.remove(startPosition);
        Collections.shuffle(mineList);
        return mineList.subList(0, mineAmount);
    }

    public void addNumbered() {
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                Tile toCheck = gameBoard.get(i).get(j);
                checkForSurroundingMines(toCheck);
            }
        }
    }

    private void checkForSurroundingMines(Tile toCheck) {
        if (toCheck.getType() == "mine") {
            return;
        }
        int startRow = toCheck.getRow() - 1;
        int endRow = toCheck.getRow() + 1;
        int startCol = toCheck.getCol() - 1;
        int endCol = toCheck.getCol() + 1;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (i < 0 || j < 0) {
                    continue;
                }
                if (i >= maxRows || j >= maxCols) {
                    continue;
                }
                Tile check = gameBoard.get(i).get(j);
                if (check.getType() == "mine") {
                    toCheck.setType("numbered");
                    toCheck.setValue(toCheck.getValue() + 1);
                }
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < (maxRows * 2) + 1; i++) {
            if (i == 0) {
                System.out.printf("  ");
                for (int j = 0; j < maxCols; j++) {
                    System.out.printf("  %d ", j);
                }
                System.out.println();
            }
            if (i % 2 == 0) {
                for (int j = 0; j < maxCols; j++) {
                    if (j == 0) {
                        System.out.printf("  ");
                    }
                    System.out.printf(" %s", HORIZONTAL_LINE);
                }
                System.out.println();
            } else {
                for (int j = 0; j < (maxCols * 2) + 1; j++) {
                    if (j == 0) {
                        System.out.printf("%c ", ((char) 65 + (i / 2)));
                    }
                    if (j % 2 == 0) {
                        System.out.printf("%s", VERTICAL_LINE);
                    } else {
                        System.out.printf(printCell(gameBoard.get(i / 2).get(j / 2)));
                    }
                }
                System.out.println();
            }

        }
        return;
    }

    public void debugPrintBoard() {
        for (int i = 0; i < (maxRows * 2) + 1; i++) {
            if (i == 0) {
                System.out.printf("  ");
                for (int j = 0; j < maxCols; j++) {
                    System.out.printf("  %d ", j);
                }
                System.out.println();
            }
            if (i % 2 == 0) {
                for (int j = 0; j < maxCols; j++) {
                    if (j == 0) {
                        System.out.printf("  ");
                    }
                    System.out.printf(" %s", HORIZONTAL_LINE);
                }
                System.out.println();
            } else {
                for (int j = 0; j < (maxCols * 2) + 1; j++) {
                    if (j == 0) {
                        System.out.printf("%c ", ((char) 65 + (i / 2)));
                    }
                    if (j % 2 == 0) {
                        System.out.printf("%s", VERTICAL_LINE);
                    } else {
                        Tile revealed = this.gameBoard.get(i / 2).get(j / 2);
                        // System.out.printf("%s ", revealed.getRow());
                        // System.out.printf("%s ", revealed.getCol());

                        System.out.printf("%s", debugPrintCell(revealed));
                    }
                }
                System.out.println();
            }

        }
        return;
    }

    private String debugPrintCell(Tile tile) {
        // if (tile.getIsRevealed() == false) {
        // return " ";
        // }
        String value = "";
        String color = "";
        String bgColor = "";
        switch (tile.getType()) {
            case "mine":
                value = MINE;
                color = BLACK_BOLD;
                bgColor = RED_BACKGROUND;
                break;
            case "blank":
                value = " ";
                break;
            case "numbered":
                value = String.format("%d", tile.getValue());
                color = getColor(tile.getValue());
                break;
            default:
                break;
        }
        // System.out.println(tile.getType());
        // if (tile.getType() == "mine") {
        // System.out.printf("%s%s %s %s", bgColor, color, value, ANSI_RESET);
        // }
        return String.format("%s%s %s %s", bgColor, color, value, ANSI_RESET);
    }

    private static String printCell(Tile tile) {
        if (tile.getIsRevealed() == false) {
            return "   ";
        }
        String value = "";
        String color = "";
        String bgColor = "";
        switch (tile.getType()) {
            case "mine":
                value = MINE;
                color = BLACK_BOLD;
                bgColor = RED_BACKGROUND;
                break;
            case "blank":
                value = " ";
                break;
            case "number":
                value = String.format("%d", tile.getValue());
                color = getColor(tile.getValue());
                break;
            default:
                break;
        }
        return String.format("%s%s %s %s", bgColor, color, value, ANSI_RESET);
    }

    private static String getColor(int value) {
        String color = "";
        switch (value) {
            case 1:
                color = BLUE_BOLD;
                break;
            case 2:
                color = GREEN_BOLD;
                break;
            case 3:
                color = RED_BOLD;
                break;
            case 4:
                color = YELLOW_BOLD;
                break;
            case 5:
                color = PURPLE_BOLD;
                break;
            case 6:
                color = CYAN_BOLD;
                break;
            case 7:
                color = BLACK_BOLD;
                break;
            case 8:
                color = WHITE_BOLD;
                break;
        }
        return color;
    }

    public void dumpBoardValues() {
        for (int i = 0; i < maxRows; i++) {
            for (int j = 0; j < maxCols; j++) {
                System.out.printf("%s, ", gameBoard.get(i).get(j).getType());
            }
        }
    }
}
