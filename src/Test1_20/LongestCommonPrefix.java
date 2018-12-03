package Test1_20;

import java.util.Stack;

/**
 * @author yangshunfan 2018/10/18 22:02
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Stack<String> stack = new Stack<>();
        stack.push("");
        String longest;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i > strs[0].length()) {
                return stack.pop();
            } else {
                longest = strs[0].substring(0, i);
            }
            for (int j = 0; j < strs.length; j++) {
                if (i > strs[j].length()) {
                    return stack.pop();
                }
                String preStr = strs[j].substring(0, i);
                if (preStr.equals(longest)) {
                    if (j == strs.length - 1) {
                        stack.push(preStr);
                    }
                } else {
                    return stack.pop();
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
}
