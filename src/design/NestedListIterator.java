package design;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListIterator implements Iterator<Integer> {
	/*
	 * Given a nested list of integers, implement an iterator to flatten it.
	 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
	 * 
	 * Example 1:
	 * Given the list [[1,1],2,[1,1]],
	 * By calling next repeatedly until hasNext returns false,
	 * the order of elements returned by next should be: [1,1,2,1,1].
	 * 
	 * Example 2:
	 * Given the list [1,[4,[6]]],
	 * By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
	 * 
	 * Leetcode #341, Medium
	 * Facebook, Google, Twitter
	 */
	Stack<NestedInteger> stack;

	public NestedListIterator(List<NestedInteger> nestedList) {
		stack = new Stack<NestedInteger>();
		pushToStack(nestedList);
	}

	private void pushToStack(List<NestedInteger> nestedList) {
		if (nestedList == null) return;
		for (int i = nestedList.size() - 1; i >= 0; i--) {
			stack.push(nestedList.get(i));
		}
	}

	public Integer next() {
		// this will bring the next integer to the top of the stack
		hasNext();
		return stack.pop().getInteger();
	}

	public boolean hasNext() {
		while (!stack.isEmpty()) {
			NestedInteger ni = stack.peek();
			if (ni.isInteger()) return true;
			ni = stack.pop();
			pushToStack(ni.getList());
		}
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}
}
