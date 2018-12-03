package Test21_40;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangshunfan 2018/11/17 16:33
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        //根据每个单词的长度设置map
        Map<Integer, List<String>> map = new HashMap<>();
        int len = 0;
        int minNum = Integer.MAX_VALUE;
        for (String word : words) {
            len += word.length();
            minNum = Math.min(minNum, word.length());
            addMap(map, word);
        }
        int left = 0, right = len;
        while (right <= s.length()) {
            String temp = s.substring(left, right);
            if (containWords(temp, map, minNum)) {
                list.add(left);
                left++;
            } else {
                left += 1;
            }
            right = left + len;
            map = initMap(map, words);
        }
        return list;
    }

    private void addMap(Map<Integer, List<String>> map, String word) {
        if (map.containsKey(word.length())) {
            map.get(word.length()).add(word);
        } else {
            List<String> wordList = new LinkedList<>();
            wordList.add(word);
            map.put(word.length(), wordList);
        }
    }

    private Map<Integer, List<String>> initMap(Map<Integer, List<String>> oldMap, String[] words) {
        Map<Integer, List<String>> map = new HashMap<>(oldMap.size());
        for (String word : words) {
            addMap(map, word);
        }
        return map;
    }

    private boolean containWords(String word, Map<Integer, List<String>> map, Integer minNum) {
        int leftIndex = 0;
        int rightIndex = 1;
        boolean result = false;
        while (rightIndex <= word.length()) {
            String temp = word.substring(leftIndex, rightIndex);
            if (map.containsKey(temp.length()) && map.get(temp.length()).contains(temp)) {
                result = true;
                map.get(temp.length()).remove(temp);
                leftIndex = rightIndex;
                rightIndex = leftIndex + minNum;
            } else {
                result = false;
                rightIndex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"aa","aa","aa"};
        String s = "aaaaaaaa";
        FindSubstring findSubstring = new FindSubstring();
        System.out.println(findSubstring.findSubstring(s, words));
    }
}
