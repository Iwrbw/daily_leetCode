package Test21_40;

import java.util.Stack;

/**
 * @author yangshunfan 2018/11/20 22:34
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0, start = 0;
        if (null == s) {
            return 0;
        }

        int len = s.length();

        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < len; index++){
            //遇左括号(，压栈(栈中元素为当前位置所处的下标)
            if('(' == s.charAt(index)){
                stack.push(index);
            } else {
                if (stack.isEmpty()) {
                    start = index + 1;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(max, index - start + 1);
                    } else {
                        max = Math.max(max, index - stack.peek());
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "(()))())(";
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(s));
    }
}
