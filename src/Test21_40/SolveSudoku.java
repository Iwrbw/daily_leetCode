package Test21_40;

/**
 * @author yangshunfan 2018/12/1 14:04
 */
public class SolveSudoku {
    public void solveSudoku(String[][] board) {
        solveSudoku2(board);
    }

    private boolean solveSudoku2(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String num = board[i][j];
                if (!".".equals(num)) {
                    continue;
                }
                for (int k = 1; k <= 9; k++) {
                    if (!isValid(board, i, j, String.valueOf(k))) {
                        continue;
                    }
                    board[i][j] = String.valueOf(k);
                    boolean isSudoku = solveSudoku2(board);
                    if (isSudoku) {
                        return true;
                    } else {
                        board[i][j] = ".";
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isValid(String[][] board, int i, int j, String num) {
        // 行不重复
        for (int col = 0; col < 9; col++){
            if (board[i][col].equals(num)){
                return false;
            }
        }
        // 列不重复
        for (int row = 0; row < 9; row++){
            if (board[row][j].equals(num)){
                return false;
            }
        }
        // 3 X 3的小方格不重复
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++){
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++){
                if (board[row][col].equals(num)){
                    return false;
                }
            }
        }
        return true;

    }
    

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        String[][] board = {
                {".",".",".","8",".","9",".",".","."},
                {".","2",".",".",".",".","4","3","."},
                {"7",".",".",".",".",".",".",".","."},
                {"5",".","9",".",".","1",".",".","3"},
                {".",".",".",".",".",".",".",".","."},
                {".",".",".",".","3",".",".","2","."},
                {".",".","1",".",".",".","5",".","9"},
                {".",".",".",".",".",".",".",".","."},
                {".","3","8",".","2",".",".",".","."}
        };
        solveSudoku.solveSudoku2(board);
        for (String[] aBoard : board) {
            for (int j = 0; j < aBoard.length; j++) {
                System.out.print(aBoard[j] + " ");
            }
            System.out.println();
        }
    }
}
