package Test1_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author yangshunfan 2018/10/30 21:08
 */
public class IsValid {
    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        for (Character c : arr) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            if (map.containsKey(stack.peek())) {
                if (map.get(stack.peek()).equals(c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()[]";
        System.out.println(isValid(s));
    }
}
