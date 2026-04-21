public class TicTacToeUC5 {

    static char[][] board = {
        {'-', '-', '-'},
        {'-', '-', '-'},
        {'-', '-', '-'}
    };

    public static void main(String[] args) {

        int row = 1;
        int col = 1;

        if (isValidMove(row, col)) {
            System.out.println("Valid Move");
        } else {
            System.out.println("Invalid Move");
        }
    }

    static boolean isValidMove(int row, int col) {

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }

        if (board[row][col] != '-') {
            return false;
        }

        return true;
    }
}