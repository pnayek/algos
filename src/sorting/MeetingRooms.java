package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class MeetingRooms {
	/*
	 * Given an array of meeting time intervals consisting of start and end times
	 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
	 * For example, given [[0, 30],[5, 10],[15, 20]], return false.
	 * 
	 * Leetcode #252, Easy
	 * Facebook
	 */
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	// O(n lg n), O(1)
	public boolean canAttendMeetingsSort(Interval[] intervals) {
		// sort the intervals in increasing order of start time
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			} 
		});
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) {
				return false;
			}
		}
		return true;
	}
	
	// O(n lg n), O(n)
	public boolean canAttendMeetings(Interval[] intervals) {
        TreeMap<Integer, Interval> map = new TreeMap<Integer, Interval>();
        for (Interval i: intervals) {
            if (map.containsKey(i.start)) return false;
            Integer prev = map.lowerKey(i.start);
            if (prev != null && i.start < map.get(prev).end) return false;
            Integer next = map.higherKey(i.start);
            if (next != null && i.end > map.get(next).start) return false;
            map.put(i.start, i);
        }
        return true;
    }
}
