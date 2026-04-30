class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                // record for row
                if (rows[i][num] == 0) {
                    rows[i][num] = 1;
                } else return false;
                // record for col
                if (columns[j][num] == 0) {
                    columns[j][num] = 1;
                } else return false;
                // record for box
                // calculate box
                int k = (i / 3) * 3 + (j / 3);
                if (box[k][num] == 0) {
                    box[k][num] = 1;
                } else return false;
            }
        }
        return true;
    }
}
