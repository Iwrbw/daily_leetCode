package Test41_60;

/**
 * @author yangshunfan on 2018/12/28
 * 58. 最后一个单词的长度
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        return strings[strings.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "     asdf     ";
        System.out.println(lengthOfLastWord.lengthOfLastWord(s));
    }
}
