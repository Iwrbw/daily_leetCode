package Test1_20;

/**
 * @author yangshunfan 2018/10/14 20:34
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
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
}
