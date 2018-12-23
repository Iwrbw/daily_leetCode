package game.weekly_contest_116;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author yangshunfan 2018/12/23 10:32
 * 961. 重复 N 次的元素
 */
public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int n = A.length / 2;
        Map<Integer, Integer> map = new HashMap<>(n + 1);
        for (int num : A) {
            if (map.containsKey(num)) {
                int time = map.get(num);
                map.put(num, time + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {5,1,5,2,5,3,5,4};
        RepeatedNTimes repeatedNTimes = new RepeatedNTimes();
        System.out.println(repeatedNTimes.repeatedNTimes(arr));
    }
}
