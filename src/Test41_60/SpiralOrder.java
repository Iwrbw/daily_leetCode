package Test41_60;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/25 21:37
 * 54. 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<>();
        if (matrix == null) {

            return list;
        }

        int row = matrix.length;
        if (row == 0) {
            return list;
        }
        int column = matrix[0].length;

        if (column == 0) {
            return list;
        }
        int time = 0;
        find_list:
            while (time <= row / 2 && time <= column / 2) {
                if (time >= 1) {
                    list.remove(list.size() - 1);
                }
                time++;
                //将最上层横排加入
                int top = time - 1;
                for (int i = top; i < matrix[top].length - time + 1; i++) {
                    list.add(matrix[top][i]);
                    if (list.size() == row * column) {
                        break find_list;
                    }
                }
                //在将右边加入
                int right = column - time;
                list.remove(list.size() - 1);
                for (int i = time - 1; i < matrix.length - time + 1; i++) {
                    list.add(matrix[i][right]);
                    if (list.size() == row * column) {
                        break find_list;
                    }
                }
                //将最下面的加入
                int down = row - time;
                list.remove(list.size() - 1);
                for (int i = matrix[down].length - time; i >= time - 1; i--) {
                    list.add(matrix[down][i]);
                    if (list.size() == row * column) {
                        break find_list;
                    }
                }
                //将最左边的加入
                int left = time - 1;
                list.remove(list.size() - 1);
                for (int i = row - left - 1; i >= time - 1; i--) {
                    list.add(matrix[i][left]);
                    if (list.size() == row * column && row != column) {
                        break find_list;
                    }
                }
            }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] matrix2 = {
                {1, 2, 3, 4, 20},
                {5, 6, 7, 8, 21},
                {9,10,11,12, 22},
                {1,1,1,1, 1}
        };

        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9,10,11,12}
        };
        SpiralOrder spiralOrder = new SpiralOrder();
        System.out.println(spiralOrder.spiralOrder(matrix));
        System.out.println(spiralOrder.spiralOrder(matrix).size());
        System.out.println(spiralOrder.spiralOrder(matrix2));
        System.out.println(spiralOrder.spiralOrder(matrix2).size());
        System.out.println(spiralOrder.spiralOrder(matrix3));
        System.out.println(spiralOrder.spiralOrder(matrix3).size());
    }
}
