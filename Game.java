import java.util.Scanner;

// Game-class decides the game flow (rules + turn order)
public class Game {

    private Board board;          // The game board
    private String currentPlayer; // Current player ("X" or "O")
    private Scanner scanner;      // read input from console

    // Constructor
    public Game() {
        board = new Board();          // make a new board
        currentPlayer = "X";          // X always starts
        scanner = new Scanner(System.in);
    }

    
    public void start() { // Starts the game loop

        // new game loop
        while (true) {

            board.resetBoard();   // Reset the board for a new match(removes X and O)
            currentPlayer = "X";  

            System.out.println("New game started!");

            // Single match loop
            while (true) {

                board.printBoard(); 

                // Ask current player for their move
                System.out.println("Player " + currentPlayer + ", choose a cell (a-i): ");
                String choice = scanner.nextLine().toLowerCase(); // read input

                // Attempt to make the move
                boolean moveDone = board.makeMove(choice, currentPlayer); // Try to place the mark

                if (!moveDone) { // Invalid move
                    System.out.println("Invalid move, try again.");
                    continue; // the same player to choose again
                }

                // Check for winner
                if (board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    System.out.println("Starting a new game...\n");
                    break; // new match starts
                }

                // Check for draw
                if (board.Draw()) {
                    board.printBoard();
                    System.out.println("It's a draw!");
                    System.out.println("Press Enter to start a new game...");
                    scanner.nextLine(); // Wait for user to press Enter
                    break; // stops match - new match starts
                }

                
                currentPlayer = currentPlayer.equals("X") ? "O" : "X"; // Switch player
            }
        }
    }
}
