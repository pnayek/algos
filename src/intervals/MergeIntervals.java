package intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	/*
	 * Given a collection of intervals, merge all overlapping intervals.
	 * For example,
	 * Given [1,3],[2,6],[8,10],[15,18],
	 * return [1,6],[8,10],[15,18].
	 * 
	 * Leetcode #56, Hard
	 * LinkedIn, Google, Facebook, Twitter, Microsoft, Bloomberg, Yelp
	 */
	public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
               return i1.start == i2.start ? i1.end - i2.end : i1.start - i2.start;
           } 
        });
        for (Interval i: intervals) {
            int sz = res.size();
            if (sz == 0) {
                res.add(i);
            }
            else {
                Interval prev = res.get(sz - 1);
                if (i.start <= prev.end) {
                    // merge required
                    prev.end = i.end > prev.end ? i.end : prev.end;
                }
                else {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
