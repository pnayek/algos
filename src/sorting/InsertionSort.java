package sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int v = a[i + 1];
			int j = i;
			while (j >= 0 && v < a[j]) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = v;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5, 12, 7, 1, 4, 3, 9, -1, -2};
		int[] sortedA = {-2, -1, 1, 3, 4, 5, 7, 9, 12};
		sort(a);
		if (!Arrays.equals(a, sortedA)) {
			throw new AssertionError("The array after insertion sort is not sorted");
		}
	}
}
