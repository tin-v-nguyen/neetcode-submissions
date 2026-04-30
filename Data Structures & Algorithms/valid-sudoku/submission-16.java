class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new Set[9];
        Set<Integer>[] columns = new Set[9];
        Set<Integer>[] squares = new Set[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            squares[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int square = (j / 3) * 3 + i / 3;
                int val = board[i][j] - '0';
                if (rows[j].contains(val)
                    || columns[i].contains(val)
                    || squares[square].contains(val)
                )
                {
                    return false;
                }

                rows[j].add(val);
                columns[i].add(val);
                squares[square].add(val);
            }
        }

        return true;
    }
}
