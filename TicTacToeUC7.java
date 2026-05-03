import java.util.Random;
import java.util.Scanner;

public class TicTacToeUC7 {

    static String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

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

    public static void computerMove() {
        Random rand = new Random();
        int move;
        
        while (true) {
            move = rand.nextInt(9) + 1; 
            
            if (isValidMove(move)) {
                board[move - 1] = "O";
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayBoard();


        System.out.println("Computer's move:");
        computerMove();
        
        displayBoard();

        scanner.close();
    }
}