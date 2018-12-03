package Test21_40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangshunfan 2018/11/17 16:33
 * 给定一个字符串 s 和一些长度相同的单词 words。在 s 中找出可以恰好串联 words 中所有单词的子串的起始位置。
 */
public class FindSubstringTest {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        //根据每个单词的长度设置map
        List<String> wordList = new LinkedList<>();
        int len = 0;
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (String word : words) {
            len += word.length();
            minNum = Math.min(minNum, word.length());
            maxNum = Math.max(maxNum, word.length());
            wordList.add(word);
        }
        int left = 0, right = len;
        while (right <= s.length()) {
            String temp = s.substring(left, right);
            if (containWords(temp, wordList, minNum, maxNum)) {
                list.add(left);
                left++;
            } else {
                left += 1;
            }
            right = left + len;
            wordList.clear();
            wordList.addAll(Arrays.asList(words));
        }
        return list;
    }

    private boolean containWords(String word, List<String> wordList, Integer minNum, Integer maxNum) {
        int leftIndex = 0;
        int rightIndex = minNum;
        boolean result = false;
        while (rightIndex <= word.length()) {
            if (rightIndex - leftIndex > maxNum) {
                return false;
            }
            String temp = word.substring(leftIndex, rightIndex);
            if (wordList.contains(temp)) {
                result = true;
                wordList.remove(temp);
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
        String[] words = {"word","good","best","word"};
        String s = "wordgoodgoodgoodbestword";
        FindSubstringTest findSubstring = new FindSubstringTest();
        System.out.println(findSubstring.findSubstring(s, words));
    }
}
