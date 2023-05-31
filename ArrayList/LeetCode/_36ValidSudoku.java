package ArrayList.LeetCode;

import java.util.HashSet;

public class _36ValidSudoku {

    /**
     * Time: O(n^2)
     * Space: O(n)
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cubes = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cubes.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
