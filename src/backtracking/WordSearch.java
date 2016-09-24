package backtracking;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {
	/*
	 * Given a 2D board and a word, find if the word exists in the grid.
		The word can be constructed from letters of sequentially adjacent cell,
		where "adjacent" cells are those horizontally or vertically neighboring.
		The same letter cell may not be used more than once.
		
		For example,
		Given board =
		
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.
	 *
	 * Leetcode #79, Medium
	 * Bloomberg, Facebook, Microsoft
	 * 
	 */
	
	char[][] board;
    char[] w;
    int m, n;
    
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0) return false;
        if (word.isEmpty()) return true;
        this.board = board;
        w = word.toCharArray();
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (exists(0, new HashSet<Integer>(), i, j)) return true;
        return false;
    }
    
    private boolean exists(int index, Set<Integer> seen, int i, int j) {
        if (index == w.length) return true;
        char c = w[index];
        int key = i * n + j;
        if (i < 0 || j < 0 || i >= m || j >= n || c != board[i][j] || seen.contains(key)) return false;
        seen.add(key);
        boolean res = exists(index + 1, seen, i - 1, j) ||
                        exists(index + 1, seen, i + 1, j) ||
                        exists(index + 1, seen, i, j - 1) ||
                        exists(index + 1, seen, i, j + 1);
        seen.remove(key);
        return res;
    }
}
