package Test41_60;

/**
 * @author yangshunfan 2018/12/18 21:51
 * 48. 旋转图像
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        System.out.println("初始状态");
        printArray(matrix);
        int time = 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                System.out.println("******第" + time++ + "次交换******");
                printArray(matrix);
            }
        }
        time = 1;
        System.out.println("******斜对称交换结束******");
        System.out.println("******左右对称交换开始******");
        int len = matrix[0].length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j];
                matrix[i][len - j] = temp;
                System.out.println("******第" + time++ + "次交换******");
                printArray(matrix);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{ 5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}} ;
        Rotate rotate = new Rotate();
        rotate.rotate(matrix);
    }

    private void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
