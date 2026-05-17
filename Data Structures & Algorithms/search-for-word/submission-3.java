class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j, visited)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        
        if (visited[i][j]) return false;
        
        if (board[i][j] != word.charAt(index)) return false;
        
        if (index == word.length() - 1) return true;

        visited[i][j] = true;
        boolean res = dfs(board, word, index + 1, i + 1, j, visited)
            || dfs(board, word, index + 1, i - 1, j, visited)
            || dfs(board, word, index + 1, i, j + 1, visited)
            || dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        
        return res;
                    

        

    }
}
