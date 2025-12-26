public class Board {

    private String[] cells;   // holds the 9 positions on the board

    // Constructor: runs when we create a new Board object
    public Board() {
        cells = new String[9];  // create array with 9 spaces
        resetBoard();           // fill board with numbers
    }

    private String winningLine; // to store the winning line description(how did the player win)

    public String getWinningLine() { // Return the winning line description (getter), Game can use but not change it
        return winningLine;
    }

    // fills the board with 1–9 again (used when starting a new game)
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
    // prints the current state of the board to the console
    public void printBoard() {
    System.out.println();
    System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2]);
    System.out.println("---+---+---");
    System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5]);
    System.out.println("---+---+---");
    System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8]);
    System.out.println();
}
    public boolean isWinner() {
    if (
        cells[0].equals(cells[1]) && 
        cells[1].equals(cells[2]) &&      // Row 0 1 2
        (cells[0].equals("X") || cells[0].equals("O")) // the same player
    ) { 
    return true;
    }
    if (
        cells[3].equals(cells[4]) && 
        cells[4].equals(cells[5]) &&      // Row 3 4 5
        (cells[3].equals("X") || cells[3].equals("O")) 
    ) { // Row 3 4 5
    return true;
    }
    if (
        cells[6].equals(cells[7]) && 
        cells[7].equals(cells[8]) &&      // Row 6 7 8
        (cells[6].equals("X") || cells[6].equals("O")) 
    ) { // Row 6 7 8
    return true;
    }
    if (
        cells[0].equals(cells[3]) && 
        cells[3].equals(cells[6]) &&      // Column 0 3 6
        (cells[0].equals("X") || cells[0].equals("O")) 
    ) { 
    return true;
    }
    if (
        cells[1].equals(cells[4]) && 
        cells[4].equals(cells[7]) &&      // Column 1 4 7
        (cells[1].equals("X") || cells[1].equals("O")) 
    ) { 
    return true;
    }
    if (
        cells[2].equals(cells[5]) && 
        cells[5].equals(cells[8]) &&      // Column 2 5 8
        (cells[2].equals("X") || cells[2].equals("O")) 
    ) { 
    return true;
    }
    if (
        cells[0].equals(cells[4]) && 
        cells[4].equals(cells[8]) &&      // Diagonal 0 4 8
        (cells[0].equals("X") || cells[0].equals("O")) 
    ) { 
    return true;
    }
    if (
        cells[2].equals(cells[4]) && 
        cells[4].equals(cells[6])  &&      // Diagonal 2 4 6
        (cells[2].equals("X") || cells[2].equals("O"))
    ) { 
    return true;
    }
        return false;
    }

    public boolean Draw() { // Check if all cells are filled without a winner
        boolean full = true; 
        for (String cell : cells) { // Check each cell
            if (!cell.equals("X") && !cell.equals("O")) {
                full = false;
                break;
            }
        }
        return full;
    }

    public boolean makeMove(String cell, String player) { // Attempt to place player's mark in the chosen cell
        for (int i = 0; i < cells.length; i++) { // Find the cell

        if (cells[i].equals(cell)) { // If cell is found and is unoccupied
            cells[i] = player; // Place the player's mark
            return true;
        }
    }

    return false; // Cell not found or already occupied
    }

    public boolean checkWin(String player) { // Check all winning combinations

        // Rows
        if (cells[0].equals(player) && 
            cells[1].equals(player) && 
            cells[2].equals(player)) {

            winningLine = "row (a - b - c)";    
        return true;
        }
        
        if (cells[3].equals(player) &&
            cells[4].equals(player) &&
            cells[5].equals(player)) {

            winningLine = "row (d - e - f)";
        return true;
        }
        
        if (cells[6].equals(player) && 
            cells[7].equals(player) && 
            cells[8].equals(player)) {

            winningLine = "row (g - h - i)";
        return true;
        }

        // Columns
        if (cells[0].equals(player) && 
            cells[3].equals(player) && 
            cells[6].equals(player)) {

            winningLine = "column (a - d - g)";
        return true;
        }
        
        if (cells[1].equals(player) && 
            cells[4].equals(player) && 
            cells[7].equals(player)) {

            winningLine = "column (b - e - h)";
        return true;
        }

        if (cells[2].equals(player) && 
            cells[5].equals(player) && 
            cells[8].equals(player)) {

            winningLine = "column (c - f - i)";
        return true;
        }

        // Diagonals
        if (cells[0].equals(player) && 
            cells[4].equals(player) && 
            cells[8].equals(player)) {

            winningLine = "diagonal (a - e - i)";
        return true;
        }

        if (cells[2].equals(player) && 
            cells[4].equals(player) && 
            cells[6].equals(player)) {

            winningLine = "diagonal (c - e - g)";
        return true;
        } 
    return false; // No win found
    }

}