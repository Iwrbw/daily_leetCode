package Test21_40;

/**
 * @author yangshunfan 2018/11/13 21:34
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        if (haystack.contains(needle)) {
            int len = needle.length();
            for (int i = 0; i < haystack.length() - len + 1; i++) {
                String temp = haystack.substring(i, i + len);
                if (temp.equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "a";
        String needle = "a";
        StrStr entity = new StrStr();
        System.out.println(entity.strStr(haystack, needle));
    }
}
