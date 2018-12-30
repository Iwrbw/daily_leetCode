package game.weekly_contest_117;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshunfan 2018/12/30 10:58
 * 967. 连续差相同的数字
 */
public class NumsSameConsecDiff {
    public int[] numsSameConsecDiff(int N, int K) {

        Set<String> set = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            String num = String.valueOf(i);
            help(num, N, K, set);
        }

        int[] arr = new int[set.size()];
        int i = 0;
        for (String s : set) {
            arr[i++] = Integer.valueOf(s);
        }
        return arr;
    }

    private void help(String num, int N, int K, Set<String> set) {
        if (num.length() < N) {
            String s = num.substring(num.length() - 1, num.length());
            int value = Integer.valueOf(s);
            if (value + K < 10) {
                String nn = String.valueOf(value + K);
                String res = num + nn;
                help(res, N, K, set);
            }
            if (value - K >= 0) {
                String nn = String.valueOf(value - K);
                String res = num + nn;
                help(res, N, K, set);
            }
        } else {
            set.add(num);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int k = 1;
        NumsSameConsecDiff numsSameConsecDiff = new NumsSameConsecDiff();
        int[] num = numsSameConsecDiff.numsSameConsecDiff(n, k);
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
