public class TicTacToeUC4 {

    public static void main(String[] args) {

        int slot = 7;

        System.out.println("Row: " + getRowFromSlot(slot));
        System.out.println("Column: " + getColFromSlot(slot));
    }

    static int getRowFromSlot(int slot) {

        int index = slot - 1;
        return index / 3;
    }

    static int getColFromSlot(int slot) {

        int index = slot - 1;
        return index % 3;
    }
}