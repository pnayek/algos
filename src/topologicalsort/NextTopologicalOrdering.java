package topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class NextTopologicalOrdering {
	private static boolean hasNoIncomingEdge(List<Set<Integer>> parents, int node) {
        return parents.get(node).size() == 0;
    }
    
    private static boolean getNextPermutation(int[] q, int start, int end, List<Integer> list) {
        int j = end;
        while (j > start && q[j] < q[j - 1]) {
            j--;
        }
        if (j == start) {
            // largest permutation
            // set next permutation to be the smallest permutation
            // but return false
            int i = start;
            for (int l: list)
                q[i++] = l;
            return false;
        }
        for (int k = end; k >= j; k--) {
            // swap q[j - 1] and q[k]
            int temp = q[j - 1];
            q[j - 1] = q[k];
            q[k] = temp;
        }
        // reverse q[j...end]
        for (int k = 0; k < (end - j + 1)/2; k++) {
            int temp = q[j + k];
            q[j + k] = q[end - k];
            q[end - k] = temp;
        }
        return true;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Set<Integer>> children = new ArrayList<Set<Integer>>(n + 1);
        List<Set<Integer>> parents = new ArrayList<Set<Integer>>(n + 1);
        for (int i = 0; i <= n; i++) {
            children.add(new HashSet<Integer>());
            parents.add(new HashSet<Integer>());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            children.get(u).add(v);
            parents.get(v).add(u);
        }
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();
        Set<Integer> nodes = new HashSet<Integer>();
        for (int i = 1; i <= n; i++)
            nodes.add(i);
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        
        List<Integer> level  = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            if (hasNoIncomingEdge(parents, i)) {
                level.add(i);
                nodes.remove(i);
            }
        }
        levels.add(0, level); 
        while (!nodes.isEmpty()) {
            List<Integer> prev = levels.get(0);
            List<Integer> curr = new ArrayList<Integer>();
            for (int u: prev) {
                for (int v: children.get(u)) {
                    parents.get(v).remove(u);
                    if (hasNoIncomingEdge(parents, v)) {
                        curr.add(v);
                        nodes.remove(v);
                    }
                }
            }
            Collections.sort(curr);
            levels.add(0, curr);
        }
        /*
        for (List<Integer> lev : levels) {
            for (int l : lev) {
                System.out.print("" + l + ", ");
            }
            System.out.println();
        }
        */
        int[] q = p.clone();
        int x = 0;
        boolean success = false;
        for (List<Integer> lev : levels) {
            x += lev.size();
            int start = n - x;
            int end = start + lev.size() - 1;
            success = getNextPermutation(q, start, end, lev);
            if (success) {
                break;    
            }
        }
        if (success) {
            // print q
            for (int e: q)
                System.out.print("" + e + " ");
            System.out.println();
        }
        else {
            System.out.println(-1);
        }
    }
}
