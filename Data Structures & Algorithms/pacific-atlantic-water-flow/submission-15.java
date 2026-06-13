class Solution {
    int[][] directions = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    int COLS;
    int ROWS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];    

        // initiate queue for BFS
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        for (int i = 0; i < ROWS; i++) {
            pacQ.add(new int[]{i, 0});
            atlQ.add(new int[]{i, COLS - 1});
        }

        for (int j = 0; j < COLS; j++) {
            pacQ.add(new int[]{0, j});
            atlQ.add(new int[]{ROWS - 1, j});
        }

        // search for reachable nodes from pacific
        bfs(pacQ, heights, pacific);
        // search for reachable nodes from atlantic
        bfs(atlQ, heights, atlantic);
        
        List<List<Integer>> res = new ArrayList<>();
        // intersect both sets
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(Queue<int[]> q, int[][] heights, boolean[][] ocean) {
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            ocean[r][c] = true;
            for (int[] d : directions) {
                int nr = r + d[0], nc = c + d[1];
                if (
                    nr < 0 ||
                    nr >= ROWS ||
                    nc < 0 ||
                    nc >= COLS ||
                    ocean[nr][nc] ||
                    heights[nr][nc] < heights[r][c]
                ) {
                    continue;
                }
                q.add(new int[]{nr, nc});
            }
        }
    }
}
