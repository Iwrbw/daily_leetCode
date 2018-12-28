package Test41_60;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangshunfan on 2018/12/28
 * 57. 插入区间
 */
public class Insert {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> list = new LinkedList<>();

        if (null == intervals || intervals.size() == 0) {
            list.add(newInterval);
            return list;
        }
        if (null == newInterval) {
            intervals.sort(Comparator.comparingInt(o -> o.start));
            return intervals;
        }
        intervals.add(newInterval);
        intervals.sort(Comparator.comparingInt(o -> o.start));

        for (Interval interval : intervals) {
            if (list.isEmpty() || list.getLast().end < interval.start) {
                list.add(interval);
            } else {
                list.getLast().end = Math.max(list.getLast().end, interval.end);
            }
        }
        return list;
    }

    public static void main(String[] args) {

        Interval interval1 = new Interval(1, 2);
        Interval interval2 = new Interval(3, 5);
        Interval interval3 = new Interval(6, 7);
        Interval interval4 = new Interval(8, 10);
        Interval interval5 = new Interval(12, 16);
        Interval newInterval = new Interval(4, 8);
        Insert insert = new Insert();
        List<Interval> list = new LinkedList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        list.add(interval5);
        List<Interval> res = insert.insert(list, newInterval);
        for (Interval in : res) {
            System.out.println(in.start + " " + in.end);
        }
    }
}
