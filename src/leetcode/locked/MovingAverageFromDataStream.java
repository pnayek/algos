package leetcode.locked;

import java.util.LinkedList;
import java.util.List;

public class MovingAverageFromDataStream {

	/*
	 * Given a stream of integers and a window size, calculate
	 * the moving average of all integers in the sliding window.

		For example,
		MovingAverage m = new MovingAverage(3);
		m.next(1) = 1
		m.next(10) = (1 + 10) / 2
		m.next(3) = (1 + 10 + 3) / 3
		m.next(5) = (10 + 3 + 5) / 3
	 *
	 * #346, E
	 * Google, 
	 */
	
	List<Integer> window;
    int capacity;
    int sum = 0;
    
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        capacity = size;
        window = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (window.size() < capacity) {
            window.add(val);
            sum += val;
            return 1.0 * sum / window.size();
        }
        else {
            int old = window.remove(0);
            window.add(val);
            sum += val - old;
            return 1.0 * sum / capacity;
        }
    }
}
