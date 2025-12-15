public class Board {

    private String[] cells;   // This holds the 9 positions on the board

    // Constructor: runs when we create a new Board object
    public Board() {
        cells = new String[9];  // create array with 9 spaces
        resetBoard();           // fill board with numbers
    }

    // Fills the board with 1–9 again (used when starting a new game)
    public void resetBoard() { 
        cells[0] = "a";
        cells[1] = "b";
        cells[2] = "c";
        cells[3] = "d";
        cells[4] = "e";
        cells[5] = "f";
        cells[6] = "g";
        cells[7] = "h";
        cells[8] = "i";
    }
    // Prints the current state of the board to the console
    public void printBoard() {
    System.out.println();
    System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
    System.out.println("---+---+---");
    System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
    System.out.println("---+---+---");
    System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
    System.out.println();
}
}