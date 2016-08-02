package sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int minPos = i;
			for (int j = i + 1; j < a.length; j++) {
				minPos = a[j] < a[minPos] ? j : minPos;
			}
			if (minPos != i) {
				int temp = a[i];
				a[i] = a[minPos];
				a[minPos] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {5, 12, 7, 1, 4, 3, 9, -1, -2};
		int[] sortedA = {-2, -1, 1, 3, 4, 5, 7, 9, 12};
		sort(a);
		if (!Arrays.equals(a, sortedA)) {
			throw new AssertionError("The array after selection sort is not sorted");
		}
	}
}
