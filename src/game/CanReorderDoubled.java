package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangshunfan 2018/12/9 10:59
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 A，
 * 只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，
 * 都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 */
public class CanReorderDoubled {

    /**
     * 我的答案超市，没有贴出来，下面是uwi的答案
     * @param A
     * @return
     */
    public boolean canReorderDoubled(int[] A) {
        int len = A.length;
        long[] a = new long[len];
        for (int i = 0; i < len; i++) {
            if (A[i] < 0) {
                a[i] = -A[i] * 100000000L;
            } else {
                a[i] = A[i];
            }
        }

        Arrays.sort(a);
        int p = 0;
        boolean[] done = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!done[i]) {
                done[i] = true;
                while (p < len && (a[p] != a[i] * 2 || done[p])) {
                    p++;
                }
                if (p == len) {
                    return false;
                }
                done[p] = true;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        CanReorderDoubled cr = new CanReorderDoubled();
        int[] arr = {4,-2,2,-4};
        System.out.println(cr.canReorderDoubled(arr));
    }
}
