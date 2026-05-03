import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC9{

    static String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    static String currentPlayer = "Player";

    public static void displayBoard() {
        System.out.println("\n");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("--+---+--");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("--+---+--");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("\n");
    }

    public static boolean isValidMove(int slot) {
        return !board[slot - 1].equals("X") && !board[slot - 1].equals("O");
    }

    public static void makeMove(int slot, String symbol) {
        board[slot - 1] = symbol;
    }

    public static boolean checkWin(String symbol) {
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]].equals(symbol) && 
                board[pattern[1]].equals(symbol) && 
                board[pattern[2]].equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDraw() {
        for (String s : board) {
            if (!s.equals("X") && !s.equals("O")) {
                return false;
            }
        }
        return true;
    }

    public static void switchTurn() {
        if (currentPlayer.equals("Player")) {
            currentPlayer = "Computer";
        } else {
            currentPlayer = "Player";
        }
    }

    public static void computerMove() {
        Random rand = new Random();
        int move;
        
        while (true) {
            move = rand.nextInt(9) + 1;
            
            if (isValidMove(move)) {
                makeMove(move, "O");
                break;
            }
        }
    }

    public static void playerMove(Scanner scanner) {
        int move;
        
        while (true) {
            System.out.print("Enter a slot (1-9): ");
            move = scanner.nextInt();
            
            if (move < 1 || move > 9) {
                System.out.println("Invalid move! Please enter a number between 1 and 9.");
            } else if (!isValidMove(move)) {
                System.out.println("Slot already taken! Try again.");
            } else {
                makeMove(move, "X");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameWon = false;
        boolean gameDraw = false;

        while (!gameWon && !gameDraw) {
            displayBoard();

            if (currentPlayer.equals("Player")) {
                playerMove(scanner);
            } else {
                System.out.println("Computer's turn:");
                computerMove();
            }

            gameWon = checkWin(currentPlayer.equals("Player") ? "X" : "O");
            gameDraw = checkDraw();

            if (gameWon) {
                displayBoard();
                System.out.println(currentPlayer + " wins!");
            } else if (gameDraw) {
                displayBoard();
                System.out.println("It's a draw!");
            }

            switchTurn();
        }

        scanner.close();
    }
}