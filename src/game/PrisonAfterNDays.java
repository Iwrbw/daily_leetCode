package game;

import java.util.Arrays;

/**
 * @author yangshunfan 2018/12/16 10:31
 * 957. N 天后的牢房
 */
public class PrisonAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {

        int[] newCells = new int[cells.length];
        for (int i = N; i > 0; i--) {
            if (i == N) {
                newCells = change(cells);
            } else {
                newCells = change(newCells);
            }
            System.out.println(Arrays.toString(newCells));
        }

        return newCells;
    }

    private int[] change(int[] cells) {
        int[] newCells = new int[cells.length];
        for (int i = 0; i < cells.length; i++) {
            int status = cells[i];
            //开始房间
            if (i == 0) {
                if (status == 1) {
                    if (cells[1] == 0) {
                        newCells[0] = 0;
                    } else {
                        newCells[0] = 1;
                    }
                } else {
                    newCells[0] = 0;
                }
            }
            //结束房间
            if (i == 7) {
                if (status == 1) {
                    if (cells[6] == 0) {
                        newCells[7] = 0;
                    } else {
                        newCells[7] = 1;
                    }
                } else {
                    newCells[7] = 0;
                }
            }
            //中间房间
            if (i > 0 && i < 7) {
                int num = cells[i - 1] + cells[i + 1];
                if (num == 2 || num == 0) {
                    newCells[i] = 1;
                } else {
                    newCells[i] = 0;
                }
            }
        }
        return newCells;
    }

    public static void main(String[] args) {
        PrisonAfterNDays prisonAfterNDays = new PrisonAfterNDays();
        int[] cells = {0,1,0,1,1,0,0,1};
        int day = 1000000000;
        System.out.println(Arrays.toString(prisonAfterNDays.prisonAfterNDays(cells, day)));
    }
}
