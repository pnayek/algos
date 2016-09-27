package maths;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SparseMatrixMultiplication {

	/*
	 * Given two sparse matrices A and B, return the result of AB.
	 * You may assume that A's column number is equal to B's row number.
	 * 
	 * Leetcode #311, Medium
	 * Facebook, LinkedIn
	 */

	public int[][] multiply(int[][] A, int[][] B) {
		List<Set<Integer>> rowIndices = new ArrayList<Set<Integer>>(A.length);
		List<Set<Integer>> columnIndices = new ArrayList<Set<Integer>>(B[0].length);
		for (int i = 0; i < A.length; i++) {
			rowIndices.add(new HashSet<Integer>());
		}
		for (int i = 0; i < B[0].length; i++) {
			columnIndices.add(new HashSet<Integer>());
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] != 0) {
					rowIndices.get(i).add(j);
				}
			}
		}
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].length; j++) {
				if (B[i][j] != 0) {
					columnIndices.get(j).add(i);
				}
			}
		}
		int[][] res = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			Set<Integer> si = rowIndices.get(i);
			for (int j = 0; j < B[0].length; j++) {
				Set<Integer> sj = columnIndices.get(j);
				if (si.isEmpty() || sj.isEmpty()) {
					res[i][j] = 0;
					continue;
				}
				int sum = 0;
				Set<Integer> s = new HashSet<Integer>(si);
				s.retainAll(sj);
				for (int k: s) {
					sum += A[i][k] * B[k][j];
				}
				res[i][j] = sum;
			}
		}
		return res;
	}
}
