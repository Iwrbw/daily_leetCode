package Test41_60;

/**
 * @author yangshunfan 2018/12/10 22:19
 * 43. 字符串相乘
 */
public class Multiply {
    public String multiply(String num1, String num2) {
        if (null == num1 || null == num2 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();

        for (int i = 0; i < c1.length; i++) {
            c1[i] -='0';
        }

        for (int i = 0; i < c2.length; i++) {
            c2[i] -='0';
        }

        int[] res = new int[c1.length + c2.length];

        for (int i = c1.length - 1; i >= 0; i--) {
            for (int j = c2.length - 1; j >= 0; j--) {
                res[i + j + 1] += c1[i] * c2[j];
            }
        }

        for (int i = res.length - 1; i > 0; i--) {
            int curr = res[i];
            if (curr >= 10) {
                res[i - 1] += curr / 10;
                res[i] = curr % 10;
            }
        }

        //递归开始的下标
        int i = res[0] == 0 ? 1 : 0;

        StringBuilder sb = new StringBuilder();
        for (int j = i; j < res.length; j++) {
            sb.append(res[j]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        String num1 = "123";
        String num2 = "456";


        System.out.println(multiply.multiply(num1, num2));
        System.out.println(123 * 456);
    }
}
