package game.weekly_contest_116;

/**
 * @author yangshunfan 2018/12/23 10:42
 * 962. 最大宽度坡
 * 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 */
public class MaxWidthRamp {
    public int maxWidthRamp(int[] A) {
        int maxWidth = 0;
        for (int i = 0; i < A.length; i++) {
            int temp;
            for (int j = A.length - 1; j >= 0; j--) {
                if (A[j] >= A[i]) {
                    temp = j - i;
                    maxWidth = Math.max(maxWidth, temp);
                    break;
                }
                if (maxWidth > j - i) {
                    break;
                }
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,1,0,1,9,4,0,4,1};
        MaxWidthRamp maxWidthRamp = new MaxWidthRamp();
        System.out.println(maxWidthRamp.maxWidthRamp(arr));
    }
}
