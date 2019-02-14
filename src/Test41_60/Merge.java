package Test41_60;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author yangshunfan 2018/12/27 19:45
 * 56. 合并区间
 */
public class Merge {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }
        help(intervals);
        Map<Integer, Integer> map = new HashMap<>(intervals.size());
        for (Interval in : intervals) {
            map.put(in.start, in.end);
        }
        intervals.clear();
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            intervals.add(new Interval(e.getKey(), e.getValue()));
        }
        return intervals;
    }

    private void help(List<Interval> intervals) {
        Map<Integer, Integer> map = new HashMap<>(intervals.size());
        for (Interval in : intervals) {
            if (map.containsKey(in.start)) {
                int end = Math.max(map.get(in.start), in.end);
                map.put(in.start, end);
            } else {
                map.put(in.start, in.end);
            }
        }
        boolean needMerge = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Iterator<Interval> intervalIterator = intervals.iterator();
            while (intervalIterator.hasNext()) {
                Interval interval = intervalIterator.next();
                if (interval.start == entry.getKey() && interval.end == entry.getValue()) {
                    continue;
                }
                if (entry.getValue() >= interval.start && entry.getKey() <= interval.end) {
                    int start = Math.min(interval.start, entry.getKey());
                    int end = Math.max(interval.end, entry.getValue());
                    intervalIterator.remove();
                        intervals.add(new Interval(start, end));
                    for (Interval in : intervals) {
                        if (in.start == entry.getKey() && in.end == entry.getValue()) {
                            intervals.remove(in);
                            break;
                        }
                    }
                    needMerge = true;
                    break;
                }
            }
        }
        if (needMerge) {
            help(intervals);
        }
    }


    /**
     * 答案
     */
    public List<Interval> mergeAnswer(List<Interval> intervals) {
        if(intervals==null||intervals.size()<=1) {
            return intervals;
        }
        LinkedList<Interval> list = new LinkedList<>();
        intervals.sort(Comparator.comparingInt(o -> o.start));

        for(Interval interval : intervals){
            if(list.isEmpty() || list.getLast().end < interval.start){
                list.add(interval);
            } else{
                list.getLast().end = Math.max(list.getLast().end,interval.end);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Interval interval1 = new Interval(1,3);
        Interval interval2 = new Interval(1,3);
        Interval interval3 = new Interval(8,10);
        Interval interval4 = new Interval(15,16);
        Merge merge = new Merge();
        List<Interval> list = new LinkedList<>();
        list.add(interval1);
        list.add(interval2);
        list.add(interval3);
        list.add(interval4);
        List<Interval> res = merge.mergeAnswer(list);
        for (Interval in : res) {
            System.out.println(in.start + " " + in.end);
        }
    }
}
