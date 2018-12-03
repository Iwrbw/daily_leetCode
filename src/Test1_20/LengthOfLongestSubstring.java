package Test1_20;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/5 21:11
 */
public class LengthOfLongestSubstring {

    /**
     * 无重复字段
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int len = 0;
        List<Character> list = new LinkedList<>();
        for (char c : arr) {
            if (list.contains(c)) {
                len = Math.max(list.size(), len);
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next();
                    if (list.contains(c)) {
                        iterator.remove();
                    } else {
                        break;
                    }
                }
            }
            list.add(c);
        }

        return Math.max(list.size(), len);
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
