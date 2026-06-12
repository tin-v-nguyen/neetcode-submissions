class Solution {

    private int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();

        boolean[][] atl = new boolean[ROWS][COLS];
        boolean[][] pac = new boolean[ROWS][COLS];

        // search for reachable nodes from left and right sides
        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, heights, pac, 0);
            dfs(i, COLS - 1, heights, atl, 0);
        }
        // search for reachable nodes from top and bottom
        for (int j = 0; j < COLS; j++) {
            dfs(0, j, heights, pac, 0);
            dfs(ROWS - 1, j, heights, atl, 0);
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

    private void dfs(int r, int c, int[][] heights, boolean[][] ocean, int prevH) {
        if (r < 0 || r >= heights.length) return;
        if (c < 0 || c >= heights[r].length) return;
        if (ocean[r][c]) return;

        int currH = heights[r][c];
        if (prevH > currH) return;
        // set node to true 
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            dfs(nextR, nextC, heights, ocean, currH);
        }
    }
}
