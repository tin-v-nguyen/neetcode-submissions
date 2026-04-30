class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    flood(grid, i, j);
                }
            }
        }
        return count;
    }

    private void flood(char[][] grid, int i, int j) {
        if (i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        flood(grid, i - 1, j);
        flood(grid, i + 1, j);
        flood(grid, i, j - 1);
        flood(grid, i, j + 1);
    }
}
