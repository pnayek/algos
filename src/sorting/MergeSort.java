package sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] sort(int[] a, int start, int end) {
		if (end < start) {
			int[] b = {};
			return b;
		}
		else if (end == start) {
			int[] b = {a[start]};
			return b;
		}
		else {
			int mid = (start + end) / 2;
			int[] a1 = sort(a, start, mid);
			int[] a2 = sort(a, mid + 1, end);
			int[] a3 = merge(a1, a2);
			return a3;
		}
	}
	
	private static int[] merge(int[] a1, int[] a2) {
		int l1 = a1.length;
		int l2 = a2.length;
		int l = l1 + l2;
		int[] a3 = new int[l];
		int i = 0; int j = 0; int k = 0;
		while (i < l1 && j < l2) {
			a3[k++] = a1[i] <= a2[j] ? a1[i++] : a2[j++];
		}
		if (i == l1) {
			// copy rest of a2
			while (j < l2) {
				a3[k++] = a2[j++];
			}
		}
		else {
			// copy rest of a1
			while (i < l1) {
				a3[k++] = a1[i++];
			}
		}
		return a3;
	}
	
	public static void main(String[] args) {
		int[] a = {5, 12, 7, 1, 4, 3, 9, -1, -2};
		int[] sortedA = {-2, -1, 1, 3, 4, 5, 7, 9, 12};
		int[] a1 = sort(a, 0, a.length - 1);
		if (!Arrays.equals(a1, sortedA)) {
			throw new AssertionError("The array after merge sort is not sorted");
		}
	}
}
