package Test21_40;

/**
 * @author yangshunfan 2018/12/3 22:23
 * 38.报数
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String fir = "11";
        char[] ch = fir.toCharArray();
        int count = 1;
        int n1;
        while (n > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < ch.length; i++) {
                n1 = ch[i];
                if (n1 == ch[i - 1]) {
                    count++;
                } else {
                    sb.append(count).append(ch[i - 1]);
                    count = 1;
                }
                if (i == ch.length - 1) {
                    sb.append(count).append(ch[i]);
                }
            }
            count=1;
            ch=sb.toString().toCharArray();
            n--;
        }
        return String.valueOf(ch);
    }
}
