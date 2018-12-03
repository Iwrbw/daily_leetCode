package Test1_20;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/13 20:36
 */
public class ZigZagConvert {
    public static String convert(String s, int numRows) {
        if (numRows > s.length() || numRows == 1) {
            return s;
        }
        String[] resArr = new String[numRows];
        for (int i = 0; i < numRows; i++) {
            resArr[i] = "";
        }
        int idx = 0;
        int step = 1;
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            resArr[idx] += c[i];
            if (idx == 0) {
                step = 1;
            } else if (idx == numRows - 1) {
                step = -1;
            }
            idx += step;
        }
        StringBuilder sb = new StringBuilder();
        for (String aResArr : resArr) {
            sb.append(aResArr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        String res = convert(s, 10);
        System.out.println(res);
    }
}
