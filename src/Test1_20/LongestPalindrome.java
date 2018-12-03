package Test1_20;

/**
 * @author yangshunfan 2018/10/9 22:44
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        boolean isHuiwen = false;
        String result = "";
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + max; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                if (isHuiWen(temp) && temp.length() > max) {
                    max = temp.length();
                    result = temp;
                }
            }

        }
        return result;
    }

    private static boolean isHuiWen(String s) {
        char[] arr = s.toCharArray();
        int j = arr.length;
        int i = 0;
        while (i < j) {
            if (arr[i] == arr[j - 1]) {
                j--;
                i++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabbasdfadsfadssdfasdfacc";
        System.out.println(longestPalindrome(s));
    }
}
