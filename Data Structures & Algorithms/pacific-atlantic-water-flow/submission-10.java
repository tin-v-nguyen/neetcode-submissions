class Solution {

    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    private int ROWS;
    private int COLS;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] atl = new boolean[ROWS][COLS];
        boolean[][] pac = new boolean[ROWS][COLS];

        // search for reachable nodes from left and right sides
        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, heights, pac);
            dfs(i, COLS - 1, heights, atl);
        }
        // search for reachable nodes from top and bottom
        for (int j = 0; j < COLS; j++) {
            dfs(0, j, heights, pac);
            dfs(ROWS - 1, j, heights, atl);
        }
        // cross reference the two sets for nodes that can reach both

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (atl[i][j] && pac[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean) {
        // set node to true 
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextR < 0 
                || nextR >= ROWS 
                || nextC < 0 
                || nextC >= COLS
                || heights[nextR][nextC] < heights[r][c]
                || ocean[nextR][nextC]) {
                    continue;
                }
            
            dfs(nextR, nextC, heights, ocean);
        }
    }
}
