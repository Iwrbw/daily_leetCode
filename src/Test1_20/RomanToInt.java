package Test1_20;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangshunfan 2018/10/17 23:12
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        char[] chars=s.toCharArray();
        int ret=0;
        int min=1000;
        for (int i = 0; i < chars.length; i++) {
            if (hashMap.get(chars[i])>min){
                ret-=hashMap.get(chars[i-1])*2;
            }
            min=hashMap.get(chars[i]);
            ret+=min;
        }
        return ret;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
