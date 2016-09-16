package streaming;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SummaryRanges {
	/*
	 * Given a data stream input of non-negative integers a1, a2, ..., an, ...,
	 * summarize the numbers seen so far as a list of disjoint intervals.
	 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
	 * then the summary will be:
	 * [1, 1]
	 * [1, 1], [3, 3]
	 * [1, 1], [3, 3], [7, 7]
	 * [1, 3], [7, 7]
	 * [1, 3], [6, 7]
	 * Follow up:
	 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
	 */
	class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}

	TreeMap<Integer, Interval> map; // key is the start of the interval

	/** Initialize your data structure here. */
	public SummaryRanges() {
		map = new TreeMap<Integer, Interval>();    
	}

	public void addNum(int val) {
		if (map.containsKey(val)) return;
		Integer l = map.lowerKey(val);
		Integer h = map.higherKey(val);
		if (l == null && h == null) {
			// make a new entry
			map.put(val, new Interval(val, val));
		}
		else if (l == null) {
			// h is not null
			// see if merge is possible
			if (h == val + 1) {
				// merge
				Interval v = map.remove(h);
				v.start = val;
				map.put(val, v);
			}
			else {
				// make a new entry
				map.put(val, new Interval(val, val));
			}
		}
		else if (h == null) {
			// l is not null
			// see if merge is possible
			Interval v = map.get(l);
			if (v.end >= val - 1) {
				// merge
				v.end = val > v.end ? val : v.end;
			}
			else {
				// make a new entry
				map.put(val, new Interval(val, val));
			}
		}
		else {
			// both l and h are not null
			Interval v1 = map.get(l);
			Interval v2 = map.get(h);
			if (map.get(l).end == val - 1 && h == val + 1) {
				// three-way merge
				v1.end = v2.end;
				map.remove(h);
			}
			else if (map.get(l).end >= val - 1) {
				// merge
				v1.end = val > v1.end ? val : v1.end;
			}
			else if (h == val + 1) {
				// merge
				v2.start = val;
				map.put(val, v2);
				map.remove(h);
			}
			else {
				// new entry
				map.put(val, new Interval(val, val));
			}
		}
	}

	public List<Interval> getIntervals() {
		return new ArrayList<Interval>(map.values());
	}
}
