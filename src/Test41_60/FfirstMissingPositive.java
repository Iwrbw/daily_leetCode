package Test41_60;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yangshunfan 2018/12/5 23:10
 * 41. 缺失的第一个正数
 */
public class FfirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer i :
                nums) {
            list.add(i);
        }
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!list.contains(1)) {
                return 1;
            } else {
                if (!list.contains(i)) {
                    return i;
                }
            }
        }
        return 1;
    }
}
