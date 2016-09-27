package intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
	/*
	 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
	 * find the minimum number of conference rooms required. For example,
	 * Given [[0, 30],[5, 10],[15, 20]], return 2.
	 * 
	 * Leetcode #253, Medium
	 * Facebook, Google
	 */
	public int minMeetingRooms(Interval[] intervals) {
        // sort by start times in ascending order
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        // sorted by end times is ascending order
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.end - i2.end;
            }
        });
        int peak = 0;
        for (Interval i: intervals) {
            // interval i has arrived
            while (!queue.isEmpty()) {
                Interval j = queue.peek();
                if (j.end <= i.start) {
                    queue.poll();
                }
                else {
                    break;
                }
            }
            queue.offer(i);
            peak = queue.size() > peak ? queue.size() : peak;
        }
        return peak;    
    }
}
