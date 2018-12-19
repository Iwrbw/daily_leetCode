package Test41_60;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author yangshunfan 2018/12/19 21:11
 * 49.字母异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return null;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String temp = help(str);
            if (map.containsKey(temp)) {
                map.get(temp).add(str);
            } else {
                List<String> list = new LinkedList<>();
                list.add(str);
                map.put(temp, list);
            }
        }
        List<List<String>> res = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String help(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : arr){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String[] strs = {" ", " "};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }
}
