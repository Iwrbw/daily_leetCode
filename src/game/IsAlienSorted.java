package game;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/9 10:35
 * 953. 验证外星语词典
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * 给定一组用外星语书写的单词 words，
 * 以及其字母表的顺序 order，
 * 只有当给定的单词在这种外星语中按字典序排列时，返回 true；
 * 否则，返回 false。
 */
public class IsAlienSorted {
    public boolean isAlienSorted(String[] words, String order) {
        List<Character> list = new LinkedList<>();
        char[] orderList = order.toCharArray();
        for (char c : orderList) {
            list.add(c);
        }
        boolean result = true;
        for (int i = 0; i < words.length - 1; i++) {
            result = isVaild(words[i], words[i + 1], list);
            if (!result) {
                return false;
            }
        }
        return true;
    }

    private boolean isVaild(String curr, String next, List<Character> list) {
        char[] left = curr.toCharArray();
        char[] right = next.toCharArray();
        for (int i = 0, j = 0; i < left.length && j < right.length; i++, j++) {
            int num1 = list.indexOf(left[i]);
            int num2 = list.indexOf(right[j]);
            if (num1 < num2) {
                return true;
            } else if (num1 > num2) {
                return false;
            }
        }
        return false;
    }

    /**
     * 下面是uwi的答案
     */
    public boolean isAlienSortedByUwi(String[] words, String order) {
        int n = words.length;
        String[] to = Arrays.copyOf(words, n);
        Arrays.sort(to, (a, b) -> {
            for(int i = 0;i < a.length() && i < b.length();i++){
                int pa = order.indexOf(a.charAt(i));
                int pb = order.indexOf(b.charAt(i));
                if (pa != pb) {
                    return pa - pb;
                }
            }
            return a.length() - b.length();
        });
        return Arrays.equals(words, to);
    }

    public static void main(String[] args) {
        IsAlienSorted is = new IsAlienSorted();
        String[] words = {"iekm","tpnhnbe"};
        String order = "loxbzapnmstkhijfcuqdewyvrg";
        System.out.println(is.isAlienSorted(words, order));
    }
}
