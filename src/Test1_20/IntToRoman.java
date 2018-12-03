package Test1_20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan 2018/10/16 22:20
 */
public class IntToRoman {
    public static String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>(13);
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        //除数
        int divisor = (int) Math.pow(10, String.valueOf(num).length() - 1);
        List<String> list = new LinkedList<>();
        while (num > 9) {
            int remainder = num / divisor;
            if (map.containsKey(remainder * divisor)) {
                list.add(map.get(remainder * divisor));
            } else {
                if (remainder > 5) {
                    list.add(map.get(5 * divisor));
                    for (int i = 0; i < remainder - 5; i++) {
                        list.add(map.get(divisor));
                    }
                } else {
                    for (int i = 0; i < remainder; i++) {
                        list.add(map.get(divisor));
                    }
                }
            }
            num %= divisor;
            divisor /= 10;
        }
        if (map.containsKey(num)) {
            list.add(map.get(num));
        } else {
            if (num > 5) {
                list.add(map.get(5));
                for (int i = 0; i < num - 5; i++) {
                    list.add(map.get(1));
                }
            } else {
                for (int i = 0; i < num; i++) {
                    list.add(map.get(1));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 58;
        System.out.println(intToRoman(num));
    }
}
