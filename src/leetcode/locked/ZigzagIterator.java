package leetcode.locked;

import java.util.Iterator;
import java.util.List;

public class ZigzagIterator {

	/*
	 * Given two 1d vectors, implement an iterator to return their elements alternately.

		For example, given two 1d vectors:
		
		v1 = [1, 2]
		v2 = [3, 4, 5, 6]
		By calling next repeatedly until hasNext returns false, the order of elements
		returned by next should be: [1, 3, 2, 4, 5, 6].
		
		Follow up: What if you are given k 1d vectors?
		How well can your code be extended to such cases?
		
		Clarification for the follow up question - Update (2015-09-18):
		The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
		If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
		For example, given the following input:
		
		[1,2,3]
		[4,5,6,7]
		[8,9]
		It should return [1,4,8,2,5,9,3,6,7].
	 *
	 * #281, M
	 * Google
	 */
	
	Iterator<Integer> it1, it2;
    boolean turn2; // defaults to false
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
    }

    public int next() {
        if (turn2) {
            turn2 = false;
            if (it2.hasNext()) {
                return it2.next();
            }
            else {
                return it1.next();    
            }
        }
        else {
            turn2 = true;
            if (it1.hasNext()) {
                return it1.next();
            }
            else {
                return it2.next();    
            }
        }
    }

    public boolean hasNext() {
        return it1.hasNext() || it2.hasNext();
    }
}
