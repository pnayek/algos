package misc;

import java.util.Scanner;

public class CommutingStrings {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long m = sc.nextInt();
        sc.close();
        int n = s.length();
        // find smallest repeating sequence
        int x = n;
        for (int l = 1; l < n; l++) {
        	if (n % l != 0) continue;
            boolean flag = true;
            String ref = s.substring(0, l); 
            int i = 0;
            while (flag && i + l <= n) {
                String sub = s.substring(i, i + l);
                flag = sub.equals(ref);
                i += l;
            }
            if (flag) {
            	x = l;
            	break;
            }
        }
        int MOD = 1000000007;
        long res = (m / x) % MOD;
        System.out.println(res);
    }
}
