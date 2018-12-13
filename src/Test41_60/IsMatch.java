package Test41_60;

/**
 * @author yangshunfan 2018/12/11 23:51
 * 44. 通配符匹配
 * '?'可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 */
public class IsMatch {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int pp = 0;
        int sp = 0;
        int star = -1;
        int match = 0;
        while (sp < s.length()) {
            if (pp < p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(sp))) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                star = pp;
                match = sp;
                pp++;
            } else if (star != -1) {
                pp = star + 1;
                match++;
                sp = match;
            } else {
                return false;
            }
        }
        while (pp < p.length() && p.charAt(pp) == '*') {
            pp++;
        }

        return pp == p.length();
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        String s = "aa";
        String p = "*a";
        System.out.println(isMatch.isMatch(s, p));
    }
}
