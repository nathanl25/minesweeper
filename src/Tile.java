public class Tile {
    private String type;
    private int row;
    private int col;
    private boolean isRevealed = false;
    private int value = 0;

    public Tile(String type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public void setValue(int num) {
        this.value = num;
    }

    public int getValue() {
        return this.value;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public void revealTile() {
        // if (this.isRevealed == true) {
        // System.out.println("Tile has already been selected, select a different
        // tile");
        // }
        this.isRevealed = true;
    }

    public String getType() {
        return this.type;
    }
}
