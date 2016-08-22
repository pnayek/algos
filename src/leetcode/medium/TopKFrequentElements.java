package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class TopKFrequentElements {
	/*
	 * Given a non-empty array of integers, return the k most frequent elements.
	 * For example,
	 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
	 * Note: 
	 * You may assume k is always valid, 1 ² k ² number of unique elements.
	 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

	 * Leetcode #347, Medium 
	 */
	public List<Integer> topKFrequent(int[] nums, int k) {
        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            if (map.containsKey(nums[i])) {
                count = map.get(nums[i]);
            }
            map.put(nums[i], count + 1);
        }
        
        SortedMap<Integer, Integer> sortedByValueMap = new TreeMap<Integer, Integer>(new Comparator<Integer>() {
            public int compare(Integer i, Integer j) {
                int compare = map.get(j).compareTo(map.get(i));
                return compare == 0 ? i - j : compare;
            }
        });
        
        sortedByValueMap.putAll(map);
        
        List<Integer> topK = new ArrayList<Integer>();
        int x = 0;
        for (int key: sortedByValueMap.keySet()) {
            topK.add(key);
            x++;
            if (x == k) break;
        }
        return topK;
    }
}
