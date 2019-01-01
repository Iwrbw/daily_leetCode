package Test41_60;

import java.util.Arrays;

/**
 * @author yangshunfan 2018/12/31 11:11
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1, d = n - 1, x = (n - d) / 2, y = (n - d) / 2;
        while (d > 0) {
            for (int i = 0; i < d; i++) {
                res[x][y + i] = num++;
            }
            y += d;
            for (int i = 0; i < d; i++) {
                res[x + i][y] = num++;
            }
            x += d;
            for (int i = 0; i < d; i++) {
                res[x][y - i] = num++;
            }
            y = (n - d) / 2;
            for (int i = 0; i < d; i++) {
                res[x - i][y] = num++;
            }
            d -= 2;
            x = (n - d) / 2;
            y = (n - d) / 2;
        }
        if (d == 0) {
            res[x][y] = num;
        }
        return res;
    }
}
