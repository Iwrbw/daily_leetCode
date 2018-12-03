package Test21_40;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/11/29 22:59
 */
public class IsValidSudoku {
    public boolean isValidSudoku(String[][] board) {
        //行的map
        HashMap<Integer, List<String>> rowMap = new HashMap<>(9);
        //列的map
        HashMap<Integer, List<String>> columnMap = new HashMap<>(9);
        //3x3的区域
        HashMap<Integer, List<String>> areaMap = new HashMap<>(9);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                String num = board[i][j];
                int area = judgmentArea(i, j);
                //判断行是否满足数据
                if (isValid(rowMap, num, i)) {
                    return false;
                }
                //判断列是否满足数独
                if (isValid(columnMap, num, j)) {
                    return false;
                }
                //判断区域是否慢速数独
                if (isValid(areaMap, num, area)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(HashMap<Integer, List<String>> areaMap, String num, int index) {
        if (areaMap.containsKey(index)) {
            if (!".".equals(num)) {
                if (areaMap.get(index).contains(num)) {
                    return true;
                } else{
                    areaMap.get(index).add(num);
                }
            }
        } else {
            if (!".".equals(num)) {
                List<String> list = new LinkedList<>();
                list.add(num);
                areaMap.put(index, list);
            }
        }
        return false;
    }

    private Integer judgmentArea(int row, int column) {
        if (row < 3) {
            if (column < 3) {
                return 1;
            }
            if (column < 6) {
                return 4;
            }
            return 7;
        }

        if (row < 6) {
            if (column < 3) {
                return 2;
            }
            if (column < 6) {
                return 5;
            }
            return 8;
        }
        if (column < 3) {
            return 3;
        }
        if (column < 6) {
            return 6;
        }
        return 9;
    }

    public static void main(String[] args) {
        String[][] board = {{".",".",".",".",".","3","2",".","4"},
                            {".",".",".",".","2",".",".",".","."},
                            {".",".",".",".",".",".",".",".","."},
                            {".","6",".",".",".",".","7",".","."},
                            {".",".",".",".",".",".",".",".","."},
                            {".",".",".",".","9",".",".",".","."},
                            {"3",".",".","1",".",".",".","8","."},
                            {".",".",".",".",".",".",".",".","."},
                            {".",".",".",".",".",".",".",".","."}};
        IsValidSudoku isValidSudoku = new IsValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));
    }
}
