package Test1_20;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/23 21:53
 */
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> resList = new LinkedList<>();
        backtracking("", digits, 0, resList);
        return resList;
    }

    private static void backtracking(String s, String digits, int flag, List<String> resList){
        if (digits.length() == 0) {
            return;
        }
        String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.length() <= flag) {
            resList.add(s);
            return;
        }
        String chars = strings[digits.charAt(flag) - '0'];
        //遍历一个数字对应的所有字母
        for (int i = 0; i < chars.length(); i++) {
            //将当前字符加到s上并将flag+1循环下一个数字的字母
            backtracking(s + chars.charAt(i), digits, flag + 1, resList);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
