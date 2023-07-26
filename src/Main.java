public class Main {
    public static void main(String[] args) {
        int[][] board = {
                {9, 0, 2,  0, 5, 0,  0, 1, 8},
                {0, 0, 6,  0, 0, 0,  0, 0, 0},
                {0, 0, 0,  0, 0, 4,  0, 0, 5},

                {8, 0, 9,  0, 0, 3,  2, 0, 0},
                {0, 6, 0,  0, 9, 0,  0, 0, 0},
                {0, 7, 0,  0, 0, 0,  0, 8, 0},

                {0, 8, 0,  0, 0, 0,  0, 0, 0},
                {1, 0, 5,  0, 4, 0,  0, 2, 0},
                {0, 0, 0,  7, 0, 0,  3, 0, 0}
        };
        Sudoku sudoku = new Sudoku(board);
        sudoku.printBoard();
        if(sudoku.solve()) {
            System.out.println(ConsoleColors.ANSI_GREEN + "SUCCESFULLY SOLVED!" + ConsoleColors.ANSI_RESET);
        } else {
            System.out.println(ConsoleColors.ANSI_RED + "I CAN'T TO SOLVE IT :(" + ConsoleColors.ANSI_RESET);
        }
        sudoku.printBoard();
    }
}