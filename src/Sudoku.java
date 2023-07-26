public class Sudoku {
    private int[][] board;

    Sudoku() {

    }

    Sudoku(int[][] board) {
        this.board = board;
    }

    public boolean solve() {
        for(int line = 0; line < board.length; line++) {
            for(int column = 0; column < board.length; column++) {
               if(board[line][column] == 0) {
                  for(int num = 1; num <= 9; num++) {
                      if(isValidPlacement(num, line, column)) {
                          board[line][column] = num;
                          if(solve()) {
                              return true;
                          } else {
                              board[line][column] = 0;
                          }
                      }
                  }
                  return false;
               }
            }
        }
        return true;
    }

    public void printBoard() {
        int counterColumn = 0;
        int counterLine = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(ConsoleColors.ANSI_CYAN + " " + board[i][j] + " " + ConsoleColors.ANSI_RESET);

                counterColumn++;
                if(counterColumn == 3) {
                    System.out.print(ConsoleColors.ANSI_RED + ConsoleColors.ANSI_WHITE_BACKGROUND + "||" + ConsoleColors.ANSI_RESET);
                    counterColumn = 0;
                }
            }
            System.out.println("");

            counterLine++;
            if(counterLine == 3) {
                System.out.println(ConsoleColors.ANSI_RED + ConsoleColors.ANSI_WHITE_BACKGROUND + "=================================" + ConsoleColors.ANSI_RESET);
                counterLine = 0;
            }
        }
    }

    public int[][] getBoard() {
        return this.board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    private boolean isNumberInLine(int num, int line) {
        for (int i = 0; i < board.length; i++) {
            if(board[line][i] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isNumberInBox(int num, int line, int column) {
        int boxLine = line - line % 3;
        int boxColumn = column - column % 3;

        for(int i = boxLine; i < boxLine + 3; i++) {
            for(int j = boxColumn; j < boxColumn + 3; j++) {
                if(board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isNumberInColumn(int num, int column) {
        for (int i = 0; i < board.length; i++) {
            if(board[i][column] == num) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidPlacement(int num, int line, int column) {
        return !isNumberInBox(num, line, column) && !isNumberInLine(num, line) && !isNumberInColumn(num, column);
    }
}
