/**
 * 36. Valid Sudoku
 * 
 * Topics: Hashmap, Set
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        // One set per row, per column, per box
        Set<Character>[] rows  = new HashSet[9];
        Set<Character>[] cols  = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];

        // Arrays of objects start as null, so fill each slot with an empty set
        for (int i = 0; i < 9; i++) {
            rows[i]  = new HashSet<>();
            cols[i]  = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                // Identiy the current 
                int box = (r / 3) * 3 + (c / 3);

                // add() returns false if val was already there → duplicate
                if (!rows[r].add(val) || !cols[c].add(val) || !boxes[box].add(val)) {
                    return false;
                }
            }
        }

        return true;
    }
}