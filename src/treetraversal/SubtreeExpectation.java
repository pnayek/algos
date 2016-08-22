package treetraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SubtreeExpectation {
	public static List<Map<Integer, Long>> A;
    public static List<Map<Integer, Long>> B;
    public static List<Set<Integer>> graph;
    public static int[] w;
    
    private static void insertUpdate(Map<Integer, Long> map, int key, long val) {
        // if key is present, increment existing value by val
        // otherwise insert
        long value = val;
        if (map.containsKey(key)) {
            value += map.get(key);
        }
        map.put(key, value);
    }
    
    private static void printMap(Map<Integer, Long> map) {
        System.out.print("{");
        for (int k: map.keySet()) {
            System.out.print("" + k + ": " + map.get(k) + ", ");
        }
        System.out.println("}");
    }
    
    private static void printAB(boolean printA) {
        List<Map<Integer, Long>> AB;
        if (printA) {
            System.out.println("Printing A");
            AB = A;
        }
        else {
            System.out.println("Printing B");
            AB = B;
        }
        for (int i = 0; i < AB.size(); i++) {
            System.out.print("" + i + ": ");
            printMap(AB.get(i));
        }
    }
    
    private static Map<Integer, Long> combineAB() {
        Map<Integer, Long> rootB = B.get(0);
        Map<Integer, Long> map = new HashMap<Integer, Long>(A.get(0));
        for (int k: rootB.keySet()) {
            insertUpdate(map, k, rootB.get(k));
        }
        return map;
    }
    
    private static void computeA(int root, int parent) {
        Map<Integer, Long> rootA = A.get(root);
        if (rootA.size() > 0) return;
        Set<Integer> children = graph.get(root);
        children.remove(parent);
        insertUpdate(rootA, w[root], 1);
        // compute A for each child 
        for (int child: children) {
            computeA(child, root);
            Map<Integer, Long> childA = A.get(child);
            Map<Integer, Long> currRootA = new HashMap<Integer, Long>(rootA);
            for (int key: childA.keySet()) {
                long val = childA.get(key);
                for (int ck: currRootA.keySet()) {
                	int rootKey = key + ck;
                	insertUpdate(rootA, rootKey, val);
                }
            }
        }
    }
    
    private static void computeB(int root, int parent) {
        Map<Integer, Long> rootB = B.get(root);
        if (rootB.size() > 0) return;
        Set<Integer> children = graph.get(root);
        children.remove(parent); 
        for (int child: children) {
            computeB(child, root);
            Map<Integer, Long> childB = B.get(child);
            for (int key: childB.keySet()) {
                long val = childB.get(key);
                insertUpdate(rootB, key, val);
            }
            Map<Integer, Long> childA = A.get(child);
            for (int key: childA.keySet()) {
                long val = childA.get(key);
                insertUpdate(rootB, key, val);
            }
        }
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            w = new int[n];
            graph = new ArrayList<Set<Integer>>(n);
            A = new ArrayList<Map<Integer, Long>>(n);
            B = new ArrayList<Map<Integer, Long>>(n);
            int sum = 0;
            for (int v = 0; v < n; v++) {
                w[v] = sc.nextInt();
                sum += w[v];
                graph.add(new HashSet<Integer>());
                A.add(new HashMap<Integer, Long>());
                B.add(new HashMap<Integer, Long>());
            }
            int[] a = new int[sum + 1];
            for (int x = 0; x < sum + 1; x++) {
                a[x] = sc.nextInt();
            }
            for (int e = 0; e < n - 1; e++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.get(u - 1).add(v - 1);
                graph.get(v - 1).add(u - 1);
            }
            // pick node 0 to be the root, its parent is -1
            computeA(0, -1);
            computeB(0, -1);
            printAB(true);
            printAB(false);
            
            Map<Integer, Long> map = combineAB();
            System.out.print("Combined map: ");
            printMap(map);
            
            long count = 0;
            double avg = 0;
            for (int k: map.keySet()) {
                long v = map.get(k);
                avg += v * a[k];
                count += v;
            }
            System.out.println("Total: " + avg);
            avg /= count;
            System.out.println("Count: " + count);
            System.out.println(avg);
        }
        sc.close();
    }
}
