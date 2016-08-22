package maths;

public class CountPrimes {
	
	// Sieve of Eratosthenes algorithm
	public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[] isComposite = new boolean[n];
        int dropped = 0;
        for (int i = 2; i * i < n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j < n; j += i) {
                    if (!isComposite[j]) {
                        isComposite[j] = true;
                        dropped++;
                    }
                }
            }
        }
        return n - dropped - 2; // 1 is neither prime nor composite
    }
}
