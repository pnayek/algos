package leetcode.contest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueueReconstruction {

	/*
	 * Suppose you have a random list of people standing in a queue.
	 * Each person is described by a pair of integers (h, k),
	 * where h is the height of the person and k is the number of people in
	 * front of this person who have a height greater than or equal to h.
	 * 
	 * Write an algorithm to reconstruct the queue.
	 * 
	 * Note: The number of people is less than 1,100.
	 * Example
	 * 
	 * Input:  [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
	 * Output: [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
	 * 
	 * Leetcode #406, Medium
	 */
	
	public class Pair {
        int h, k;
        public Pair(int h, int k) {
            this.h = h;
            this.k = k;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) return people;
        int m = people.length;
        int[][] queue = new int[m][2];
        for (int i = 0; i < m; i++) {
            queue[i][0] = -1;
            queue[i][1] = -1;
        }
        List<Pair> ppl = new ArrayList<Pair>(m);
        for (int[] person: people) {
            Pair p = new Pair(person[0], person[1]);
            //System.out.println("p.h: " + p.h + ", p.k: " + p.k);
            ppl.add(p);
        }
        Collections.sort(ppl, new Comparator<Pair>() {
           public int compare (Pair p1, Pair p2) {
               return p1.h == p2.h ? p1.k - p2.k : p1.h - p2.h;
           } 
        });
        for (Pair p: ppl) {
            int ph = p.h;
            int pk = p.k;
            //System.out.println("ph: " + ph + ", pk: " + pk);
            int i = 0, count = 0;
            while (count < pk && i < m) {
                if (queue[i][0] == -1 || queue[i][0] == ph) count++;
                i++;
            }
            // put it in the first vacant spot starting i
            for (int j = i; j < m; j++) {
                if (queue[j][0] == -1) {
                    queue[j][0] = ph;
                    queue[j][1] = pk;
                    //System.out.println("j: " + j);
                    break;
                    
                }
            }
        }
        return queue;
    }
}
