package game;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/2 10:33
 */
public class LargestTimeFromDigits {

    private String largestTimeFromDigitsFromUwi(int[] A) {
        int[] f = new int[10];
        for (int x : A) {
            f[x]++;
        }
        for (int h = 23; h >= 0; h--){
            for (int m = 59; m >= 0; m--){
                int[] g = new int[10];
                for (int i = h, j = 0; j < 2; i /= 10, j++) {
                    g[i % 10]++;
                }
                for (int i = m, j = 0; j < 2; i /= 10, j++) {
                    g[i % 10]++;
                }
                if (Arrays.equals(f, g)) {
                    return String.format("%02d:%02d", h, m);
                }
            }
        }
        return "";
    }
    public String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new LinkedList<>();
        for (int a : A) {
            list.add(a);
        }

        String res = canHour(list, sb, A);

        return res.length() != 5 ? "" : res;
    }

    private String canHour(List<Integer> list, StringBuilder sb, int[] A) {
        for (int i = 2; i >= 0; i--) {
            if (list.contains(i) && i == 2) {
                list.remove(Integer.valueOf(i));
                for (int j = 3; j >= 0; j--) {
                    if (list.contains(j)) {
                        list.remove(Integer.valueOf(j));
                        for (int k = 5; k >= 0; k--) {
                            if (list.contains(k)) {
                                sb.append(i);
                                sb.append(j);
                                sb.append(":");
                                sb.append(k);
                                list.remove(Integer.valueOf(k));
                                sb.append(list.get(0));
                                return sb.toString();
                            }
                        }
                        list.add(j);
                    }
                }
                if (sb.toString().length() != 5) {
                    list.clear();
                    for (int a : A) {
                        list.add(a);
                    }
                }
            } else if (list.contains(i)) {
                list.remove(Integer.valueOf(i));
                for (int j = 9; j >= 0; j--) {
                    if (list.contains(j)) {
                        list.remove(Integer.valueOf(j));
                        for (int k = 5; k >= 0; k--) {
                            if (list.contains(k)) {
                                sb.append(i);
                                sb.append(j);
                                sb.append(":");
                                sb.append(k);
                                list.remove(Integer.valueOf(k));
                                sb.append(list.get(0));
                            }
                        }
                        list.add(j);
                    }
                }
                if (sb.toString().length() != 5) {
                    list.clear();
                    for (int a : A) {
                        list.add(a);
                    }
                }
            }
        }
        return sb.toString();
    }



    public static void main(String[] args) {
        LargestTimeFromDigits largestTimeFromDigits = new LargestTimeFromDigits();
        int[] arr = {1,2,3,4};
        System.out.println(largestTimeFromDigits.largestTimeFromDigitsFromUwi(arr));
    }
}
