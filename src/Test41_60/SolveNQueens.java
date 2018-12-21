package Test41_60;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/21 22:29
 * 51. N皇后
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        String[][] queens = new String[n][n];
        List<List<String>> result = new LinkedList<>();
        for (int i = 0; i < queens.length; i++) {
            for (int j = 0; j < queens[i].length; j++) {
                queens[i][j] = ".";
            }
        }
        result = putQueen(queens, 0, n, result);
        System.out.println(result);
        return result;
    }

    private List<List<String>> putQueen(String[][] queens, int row, int n, List<List<String>> result) {
        if (row == n) {
            List<String> list = new LinkedList<>();
            for (int i = 0; i < queens.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < queens[i].length; j++) {
                    stringBuilder.append(queens[i][j]);
                }
                list.add(stringBuilder.toString());
            }
            result.add(list);
            return result;
        }

        String[][] temp = queens.clone();

        for (int i = 0; i < n; i++) {
            //摆放这一行的皇后，之前要清掉所有这一行摆放的记录，防止污染棋盘
            for (int j = 0; j < n; j++) {
                temp[row][j] = ".";
            }
            temp[row][i] = "Q";

            if (isSafety(temp, row, i, n)) {
                putQueen(temp, row + 1, n, result);
            }
        }
        return result;
    }

    private static boolean isSafety(String[][] chess, int row, int col, int n) {
        //判断中上、左上、右上是否安全
        int step = 1;
        while (row - step >= 0) {
            if("Q".equals(chess[row - step][col])) {
                return false;
            }
            if(col - step >= 0 && "Q".equals(chess[row - step][col - step])) {
                return false;
            }
            if(col + step < n && "Q".equals(chess[row - step][col + step])) {
                return false;
            }

            step++;
        }
        return true;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        int n = 4;
        solveNQueens.solveNQueens(n);
    }
}
