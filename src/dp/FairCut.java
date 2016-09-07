package dp;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FairCut {
	public static class State {
        Set<Integer> s1;
        Set<Integer> s2;
        long v = 0;
        
        public State() {
            s1 = new HashSet<Integer>();
            s2 = new HashSet<Integer>();
        }
        
        public State(State s, boolean rev) {
            if (rev) {
                s1 = new HashSet<Integer>(s.s2);
                s2 = new HashSet<Integer>(s.s1);
            }
            else {
                s1 = new HashSet<Integer>(s.s1);
                s2 = new HashSet<Integer>(s.s2);
            }
            v = s.v;
        }
        
        public long add1(int x) {
            long sum = 0;
            for (int j: s2) {
                long d = x < j ? j - x : x - j;
                sum += d;
            }
            return sum;          
        }
        
        public long add2(int x) {
            long sum = 0;
            for (int i: s1) {
                long d = x < i ? i - x : x - i;
                sum += d;
            }
            return sum;
        }
        
        public String toString(){
            StringBuilder sb = new StringBuilder();
            sb.append("s1: [");
            for (int i: s1) {
                sb.append(i);
                sb.append(", ");
            }
            sb.append("]\ns2: [");
            for (int i: s2) {
                sb.append(i);
                sb.append(", ");
            }
            sb.append("]\nv: ");
            sb.append(v);
            return sb.toString();
        }
        
    }
    
    private static State[][] cache;
    
    private static State divide(int[] a, int n, int k) {
        //System.out.println("n: " + n + ", k: " + k);
        if (cache[n][k] != null) return cache[n][k];
        if (k > n || n == 0) {
            //System.out.println("Returning empty state");
            cache[n][k] = new State();
        }
        else if (k == 0) {
            State s = new State();
            for (int i = 0; i < n; i++) {
                s.s2.add(a[i]);
            }
            cache[n][k] = s;
            if (n - k < cache[0].length) {
                State rev = new State(s, true);
                cache[n][n - k] = rev;   
            }
            
        }
        else if (k == n) {
            State s = new State();
            for (int i = 0; i < n; i++) {
                s.s1.add(a[i]);
            }
            cache[n][k] = s;
            if (n - k < cache[0].length) {
                State rev = new State(s, true);
                cache[n][n - k] = rev;   
            }
        }
        else {
            State state1 = divide(a, n - 1, k - 1);
            // add a[n - 1] to set 1
            long v1 = state1.add1(a[n - 1]);
            State state2 = divide(a, n - 1, k);
            // add a[n - 1] to set 2
            long v2 = state2.add2(a[n - 1]);
            State s = null;
            if (v1 + state1.v < v2 + state2.v) {
                s = new State(state1, false);
                s.s1.add(a[n - 1]);
                s.v = v1 + state1.v;
            }
            else {
                s = new State(state2, false);
                s.s2.add(a[n - 1]);
                s.v = v2 + state2.v;
            }
            cache[n][k] = s;
            if (n - k < cache[0].length) {
                State rev = new State(s, true);
                cache[n][n - k] = rev;   
            }
        }
        return cache[n][k];
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        cache = new State[n + 1][k + 1];
        cache[n][k] = divide(a, n, k);
        System.out.println(cache[n][k].v);
    }
}
