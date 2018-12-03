package Test1_20;

/**
 * @author yangshunfan 2018/10/14 15:50
 */
public class MyAtoi {
    public static int myAtoi(String str) {

        String s = str.trim();
        if (s.equals("") || s.length() == 0) {
            return 0;
        }
        char[] arr = s.toCharArray();
        boolean positive = true;
        int start = 0, end = 0;
        boolean isStart = false;
        if (arr[0] == '-' || arr[0] == '+') {
            if (arr.length > 1 && !Character.isDigit(arr[1])) {
                return 0;
            }

        }
        if (arr[0] == '-') {
            positive = false;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                if (!isStart) {
                    start = i;
                    isStart = true;
                }
                end = i;
            } else if ((arr[i] == '-' || arr[i] == '+') && !isStart) {
                continue;
            }
            if (arr[i] < '0' || arr[i] > '9') {
                break;
            }
        }

        String temp = s.substring(start, end + 1);
        StringBuilder sb = new StringBuilder();
        for (Character c : temp.toCharArray()) {
            if (sb.length() < 1) {
                if (c != '0') {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        for (Character c : sb.toString().toCharArray()) {
            if (!Character.isDigit(c)) {
                return 0;
            }
        }
        if (sb.length() > 18) {
            if (positive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else if (sb.length() < 1) {
            return 0;
        }
        Long res = Long.parseLong(sb.toString());
        if (res > Integer.MAX_VALUE) {
            if (positive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        return (int) (positive ? res : -res);
    }

    public static void main(String[] args) {
        String s = "-12+8";
        int res = myAtoi(s);
        System.out.println(res);
    }
}
