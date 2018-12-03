package Test21_40;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/31 21:48
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 */
public class GenerateParenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        List<String> resList = new LinkedList<>();
        addParenthesis(list, resList, 0, n);
        return resList;
    }

    private static void addParenthesis(List<String> list,List<String> resList, int num, int n) {
        if (num < n) {
            if (list.isEmpty()) {
                String s = "()";
                if (n == 1) {
                    resList.add(s);
                    return;
                }
                list.add(s);
                num++;
                addParenthesis(list, resList, num, n);
            } else {
                int len = list.size();
                for (int i = 0; i < len; i++) {
                    String str = list.get(i);
                    for (int j = 0; j < str.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        String prefix = str.substring(0, j);
                        String suffix = str.substring(j, str.length());
                        sb.append(prefix);
                        sb.append("()");
                        sb.append(suffix);
                        if (!list.contains(sb.toString())) {
                            list.add(sb.toString());
                        }
                        if (sb.toString().length() == n * 2 && !resList.contains(sb.toString())) {
                            resList.add(sb.toString());
                        }
                    }
                }
                num++;
                addParenthesis(list, resList, num, n);
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        List<String> list = generateParenthesis(n);
        System.out.println(list);
        System.out.println("list size:" + list.size());
    }
}
