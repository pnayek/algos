package leetcode.locked;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

	/*
	 * Implement an iterator to flatten a 2d vector.

		For example,
		Given 2d vector =
		
		[
		  [1,2],
		  [3],
		  [4,5,6]
		]
		By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
		
		Hint:
		
		1. How many variables do you need to keep track?
		2. Two variables is all you need. Try with x and y.
		3. Beware of empty rows. It could be the first few rows.
		4. To write correct code, think about the invariant to maintain. What is it?
		5. The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
		6. Not sure? Think about how you would implement hasNext(). Which is more complex?
		7. Common logic in two different places should be refactored into a common method.
	 *
	 * #251, M
	 * Google, Airbnb, Twitter, Zenefits
	 */
	
	Iterator<List<Integer>> it1; // iterator on vec2d
    Iterator<Integer> it2; // iterator on current list in vec2d
    
    public Vector2D(List<List<Integer>> vec2d) {
        if (vec2d != null) { 
            it1 = vec2d.iterator();
            if (it1.hasNext()) {
                List<Integer> l = it1.next();
                it2 = l.iterator();
            }
        }
    }

    @Override
    public Integer next() {
        if (it2 == null) return null;
        if (it2.hasNext()) return it2.next();
        if (it1.hasNext()) {
            List<Integer> l = it1.next();
            it2 = l.iterator();
            return next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        if (it2 == null) return false;
        if (it2.hasNext()) return true;
        if (it1.hasNext()) {
            List<Integer> l = it1.next();
            it2 = l.iterator();
            return hasNext();
        }
        return false;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
