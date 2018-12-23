package game.weekly_contest_116;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangshunfan 2018/12/23 10:52
 * 963. 最小面积矩形 II
 */
public class MinAreaFreeRect {

    /**
     * uwi的代码
     * @param points
     * @return
     */
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        long ret = Long.MAX_VALUE;
        Set<Long> set = new HashSet<>();
        int o = 100000;
        for (int[] c : points){
            set.add((long)c[0] + o << 32|c[1] + o);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < n; j++) {
                for (int k = 0; k < n; k++) {
                    long x1 = points[j][0] - points[i][0];
                    long y1 = points[j][1] - points[i][1];
                    long x2 = points[k][0] - points[i][0];
                    long y2 = points[k][1] - points[i][1];
                    if (x1 * x2 + y1 * y2 != 0) {
                        continue;
                    }
                    long s2 = (x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2);
                    if (s2 == 0) {
                        continue;
                    }
                    if (s2 >= ret) {
                        continue;
                    }
                    long x3 = points[i][0] + x1 + x2;
                    long y3 = points[i][1] + y1 + y2;
                    if (set.contains(x3 + o << 32 | y3 + o)){
                        ret = s2;
                    }
                }
            }
        }
        if (ret == Long.MAX_VALUE) {
            return 0;
        }
        return Math.sqrt(ret);
    }
}
